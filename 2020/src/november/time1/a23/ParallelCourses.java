package november.time1.a23;

import java.util.*;

public class ParallelCourses {
    /**
     * 1136. 平行课程
     * 已知有 N 门课程，它们以 1 到 N 进行编号。
     *
     * 给你一份课程关系表 relations[i] = [X, Y]，用以表示课程 X 和课程 Y 之间的先修关系：课程 X 必须在课程 Y 之前修完。
     *
     * 假设在一个学期里，你可以学习任何数量的课程，但前提是你已经学习了将要学习的这些课程的所有先修课程。
     *
     * 请你返回学完全部课程所需的最少学期数。
     *
     * 如果没有办法做到学完全部这些课程的话，就返回 -1。
     *
     * 示例 1：
     *
     * 输入：N = 3, relations = [[1,3],[2,3]]
     * 输出：2
     * 解释：
     * 在第一个学期学习课程 1 和 2，在第二个学期学习课程 3。
     * 示例 2：
     *
     * 输入：N = 3, relations = [[1,2],[2,3],[3,1]]
     * 输出：-1
     * 解释：
     * 没有课程可以学习，因为它们相互依赖。
     *
     * 提示：
     *
     * 1 <= N <= 5000
     * 1 <= relations.length <= 5000
     * relations[i][0] != relations[i][1]
     * 输入中没有重复的关系
     */

    /**
     * 拓扑排序
     *  无环有向图
     * 思路：
     *  根据节点的入度节点进行判断，每次都删除节点入读为0的节点就是学期要学的课程，
     *  如果最后学的课程数 = 课程的总数，那就可以学完，如果不相等，那就是学不完
     */

    public int minimumSemesters(int N, int[][] relations) {
        // 索引0是个填充
        int[] inDegrees = new int[N + 1];
        Arrays.fill(inDegrees, 0);
        // Map来保存节点之间的关系
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        // 填充所有节点
        for (int i = 0; i < relations.length; i++) {
            int[] relation = relations[i];
            int start = relation[0];
            int end = relation[1];
            // 计算节点的入度
            inDegrees[end] ++;
            if (!graph.containsKey(start)) {
                graph.put(start, new ArrayList<>());
            }
            graph.get(start).add(end);
        }
        // 使用bfs来进行节点的删除
        int terms = 0;
        Queue<Integer> deque = new LinkedList<>();
        for (int i = 1; i < inDegrees.length; i++) {
            // 先学的课程，注意这里的索引代表的课程，值代表的是入度
            if (inDegrees[i] == 0) {
                deque.offer(i);
            }
        }
        int courseCount = 0;
        while (!deque.isEmpty()) {
            int loop = deque.size();
            courseCount += loop;
            terms ++;
            for (int i = 0; i < loop; i++) {
                Integer poll = deque.poll();
                if (graph.containsKey(poll)) {
                    List<Integer> list = graph.get(poll);
                    for (int integer : list) {
                        // 去掉节点的一个入度节点之后，当前节点的入度是否为0，如果是，则是下一学期学习的课程
                        if (--inDegrees[integer] == 0) {
                            deque.offer(integer);
                        }
                    }
                }
            }
        }
        return courseCount == N ? terms : -1;
    }
}
