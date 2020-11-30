package november.time2.a22;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class OptimizeWaterDistributionInAVillage {
    /**
     * 1168. 水资源分配优化
     * 村里面一共有 n 栋房子。我们希望通过建造水井和铺设管道来为所有房子供水。
     *
     * 对于每个房子 i，我们有两种可选的供水方案：
     *
     * 一种是直接在房子内建造水井，成本为 wells[i]；
     * 另一种是从另一口井铺设管道引水，数组 pipes 给出了在房子间铺设管道的成本，其中每个 pipes[i] = [house1, house2, cost] 代表用管道将 house1 和 house2 连接在一起的成本。当然，连接是双向的。
     * 请你帮忙计算为所有房子都供水的最低总成本。
     *
     * 示例：
     *
     * 输入：n = 3, wells = [1,2,2], pipes = [[1,2,1],[2,3,1]]
     * 输出：3
     * 解释：
     * 上图展示了铺设管道连接房屋的成本。
     * 最好的策略是在第一个房子里建造水井（成本为 1），然后将其他房子铺设管道连起来（成本为 2），所以总成本为 3。
     *
     *
     * 提示：
     *
     * 1 <= n <= 10000
     * wells.length == n
     * 0 <= wells[i] <= 10^5
     * 1 <= pipes.length <= 10000
     * 1 <= pipes[i][0], pipes[i][1] <= n
     * 0 <= pipes[i][2] <= 10^5
     * pipes[i][0] != pipes[i][1]
     */
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        if (n == 0) {
            return 0;
        }
        int[] counts = new int[n + 1];
        Arrays.fill(counts, -1);
        // 优先队列
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        for (int[] pipe : pipes) {
            priorityQueue.add(pipe);
        }
        for (int i = 0; i < wells.length; i++) {
            priorityQueue.add(new int[]{0, i + 1, wells[i]});
        }
        int result = 0;
        int minCount = 0;
        while (minCount < n) {
            int[] poll = priorityQueue.poll();
            // 找到当前节点的父节点，没有父节点,将当前节点作为父节点
            int start = findParent(poll[0], counts);
            int end = findParent(poll[1], counts);
            // 如果两个节点的父节点相同，说明有回路，不进行合并
            if (start != end) {
                counts[start] = end;
                minCount ++;
                result += poll[2];
            }
        }
        return result;
    }

    private int findParent(int i, int[] counts) {
        if (counts[i] == -1) {
            return i;
        }
        return findParent(counts[i], counts);
    }
}
