package december.time2.a5;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    /**
     * 973. 最接近原点的 K 个点
     * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
     *
     * （这里，平面上两点之间的距离是欧几里德距离。）
     *
     * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
     *
     *
     *
     * 示例 1：
     *
     * 输入：points = [[1,3],[-2,2]], K = 1
     * 输出：[[-2,2]]
     * 解释：
     * (1, 3) 和原点之间的距离为 sqrt(10)，
     * (-2, 2) 和原点之间的距离为 sqrt(8)，
     * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
     * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
     * 示例 2：
     *
     * 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
     * 输出：[[3,3],[-2,4]]
     * （答案 [[-2,4],[3,3]] 也会被接受。）
     *
     *
     * 提示：
     *
     * 1 <= K <= points.length <= 10000
     * -10000 < points[i][0] < 10000
     * -10000 < points[i][1] < 10000
     */

    /**
     * 简单，使用大顶堆，注意的是平方的计算，自己乘自己就好
     */

    public int[][] kClosest(int[][] points, int K) {
        if (points.length == K) {
            return points;
        }
        int[][] result = new int[K][2];
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o2[0] * o2[0] + o2[1] * o2[1]) - (o1[0] * o1[0] + o1[1] * o1[1]);
            }
        });
        for (int i = 0; i < points.length; i++) {
            queue.add(points[i]);
            if (queue.size() > K) {
                queue.poll();
            }
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = queue.poll();
        }
        return result;
    }
}
