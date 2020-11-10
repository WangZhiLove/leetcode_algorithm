package november.time1.a7;

import java.util.Stack;

public class LargestRectangleInHistogram {
    /**
     * 84. 柱状图中最大的矩形
     *
     * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
     *
     * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
     *
     * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为[2,1,5,6,2,3]。
     *
     *
     * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为10个单位。
     *
     * 示例:
     *
     * 输入: [2,1,5,6,2,3]
     * 输出: 10
     */

    /**
     * 这道题目可以使用暴力法解决，但是时间复杂度嘛，O(n^2)
     * 看了leetcode老师的讲解，使用栈结构，维护一个单调递增的栈，来计算面积 O(n)
     * 关键：
     *  1. 使用栈数据结构，维护一个递增栈
     *  2. 考虑当前数字比左边小的时候，其实是计算左边数字的面积，而不是当前数字
     *  3. 需要考虑边界情况，当最后一个元素的时候，如果计算，循环的次数应该是length次，而不是length - 1
     */
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int len = heights.length;
        int result = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= len; i++) {
            int cur = i == len ? -1 : heights[i];
            while (!stack.isEmpty() && cur <= heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int left = stack.isEmpty() ? 0 : (stack.peek() + 1);
                int right = i - 1;
                int area = height * (right - left + 1);
                result = Math.max(area, result);
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
