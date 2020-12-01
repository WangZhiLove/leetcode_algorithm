package november.time2.a23;

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
     * 拓扑算法
     * 根据课程和关系获取最小的学期树
     * @param N         课程数
     * @param relations 课程的前后关系
     * @return          最小的学期数
     */
    public int minimumSemesters(int N, int[][] relations) {
        int[] visits = new int[N + 1];
        Arrays.fill(visits, 0);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < relations.length; i++) {
            int[] relation = relations[i];
            visits[relation[1]] ++;
            if (!map.containsKey(relation[0])) {
                map.put(relation[0], new ArrayList<>());
            }
            map.get(relation[0]).add(relation[1]);
        }
        // bfs
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < visits.length; i++) {
            if (visits[i] == 0) {
                // 第一学期需要学习的课程
                queue.offer(i);
            }
        }
        int terms = 0;
        int courseCount = 0;
        while (!queue.isEmpty()) {
            int loop = queue.size();
            terms += 1;
            courseCount += loop;
            for (int i = 0; i < loop; i++) {
                Integer poll = queue.poll();
                // 为什么要判断呢？ 初度节点为0的节点没有后继
                if (map.containsKey(poll)) {
                    List<Integer> list = map.get(poll);
                    for (Integer integer : list) {
                        visits[integer] -- ;
                        if (visits[integer] == 0) {
                            queue.offer(integer);
                        }
                    }
                }

            }
        }
        return courseCount == N ? terms : -1;
    }
}
