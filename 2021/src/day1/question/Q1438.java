package day1.question;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Q1438 {

    /**
     * 1438. 绝对差不超过限制的最长连续子数组
     * 给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
     *
     * 如果不存在满足条件的子数组，则返回 0 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [8,2,4,7], limit = 4
     * 输出：2
     * 解释：所有子数组如下：
     * [8] 最大绝对差 |8-8| = 0 <= 4.
     * [8,2] 最大绝对差 |8-2| = 6 > 4.
     * [8,2,4] 最大绝对差 |8-2| = 6 > 4.
     * [8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
     * [2] 最大绝对差 |2-2| = 0 <= 4.
     * [2,4] 最大绝对差 |2-4| = 2 <= 4.
     * [2,4,7] 最大绝对差 |2-7| = 5 > 4.
     * [4] 最大绝对差 |4-4| = 0 <= 4.
     * [4,7] 最大绝对差 |4-7| = 3 <= 4.
     * [7] 最大绝对差 |7-7| = 0 <= 4.
     * 因此，满足题意的最长子数组的长度为 2 。
     * 示例 2：
     *
     * 输入：nums = [10,1,2,4,7,2], limit = 5
     * 输出：4
     * 解释：满足题意的最长子数组是 [2,4,7,2]，其最大绝对差 |2-7| = 5 <= 5 。
     * 示例 3：
     *
     * 输入：nums = [4,2,2,2,4,4,2,2], limit = 0
     * 输出：3
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 10^5
     * 1 <= nums[i] <= 10^9
     * 0 <= limit <= 10^9
     */
    /**
     * 思路：就是计算滑动窗口内的最大值和最小值的绝对值要小于等于limit，思路没问题，但是代码不会写，也就是对数据结构还是不熟悉
     * 这里使用滑动窗口 + 单调队列来实现
     * @param nums
     * @param limit
     * @return
     */
    public static int longestSubarray(int[] nums, int limit) {
        Deque<Integer> max = new LinkedList<>();
        Deque<Integer> min = new LinkedList<>();
        int left = 0;
        int right = 0;
        int result = 0;
        while (right < nums.length) {
            while (!max.isEmpty() && max.peekLast() < nums[right]) {
                max.pollLast();
            }
            while (!min.isEmpty() && min.peekLast() > nums[right]) {
                min.pollLast();
            }
            max.offerLast(nums[right]);
            min.offerLast(nums[right]);
            while (!max.isEmpty() && !min.isEmpty() & max.peekFirst() - min.peekFirst() > limit) {
                if (nums[left] == max.peekFirst()) {
                    max.pollFirst();
                }
                if (nums[left] == min.peekFirst()) {
                    min.pollFirst();
                }
                left ++;
            }
            result = Math.max(right - left + 1, result);
            right ++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{8,2,4,7}, 4));
    }
}
