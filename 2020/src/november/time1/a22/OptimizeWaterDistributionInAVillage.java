package november.time1.a22;

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

    /**
     * 并查集的使用
     * - 并查集用来判断图有无还的示例
     * 并查集两个操作：查找和合并
     */
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        if (n <= 0) {
            return 0;
        }
        // 需要一个虚拟点，来作为额外的wells开销
        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);
        // 优先队列，开销最小
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        // 将所有节点的开销加入到队列中
        for (int[] pipe : pipes) {
            queue.add(pipe);
        }
        for (int i = 0; i < wells.length; i++) {
            queue.add(new int[]{0, i + 1, wells[i]});
        }
        int result = 0;
        int minCount = 0;
        while (minCount < n) {
            int[] poll = queue.poll();
            // 并查集找到节点的父节点
            int nodeStart = find(parent, poll[0]);
            int nodeEnd = find(parent, poll[1]);
            if (nodeStart != nodeEnd) {
                // 合并
                parent[nodeStart] = nodeEnd;
                minCount ++;
                result += poll[2];
            }
        }
        // 开始进行查找和合并
        return result;
    }

    private int find(int[] parent, int i) {
        if (parent[i] == -1) {
            return i;
        }
        return find(parent, parent[i]);
    }

    public static void main(String[] args) {
        OptimizeWaterDistributionInAVillage optimizeWaterDistributionInAVillage = new OptimizeWaterDistributionInAVillage();
        int i = optimizeWaterDistributionInAVillage.minCostToSupplyWater(3, new int[]{1, 2, 2}, new int[][]{
                {1, 2, 1}, {2, 3, 1}
        });
        System.out.println(i);

    }
}
