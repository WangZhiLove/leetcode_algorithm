package november.time1.a10;

import java.util.Stack;

public class TrappingRainAater {
    /**
     * 42. 接雨水
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     *
     * 示例 1：
     *
     * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出：6
     * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
     * 示例 2：
     *
     * 输入：height = [4,2,0,3,2,5]
     * 输出：9
     *
     * 提示：
     *
     * n == height.length
     * 0 <= n <= 3 * 104
     * 0 <= height[i] <= 105
     */

    /**
     * 配对题目考虑栈结构
     */
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int index = 0;
        // 理解流程，三根柱子才可以形成积水槽
        while (index < height.length) {
            while (!stack.isEmpty() && height[index] > height[stack.peek()]) {
                int height1 = height[stack.pop()];
                if (stack.isEmpty()) {
                    break;
                }
                // 关键点1，计算宽度
                int width = index - stack.peek() - 1;
                // 关键点2 计算高度
                int height2 = Math.min(height[index], height[stack.peek()]) - height1;
                result += width * height2;
            }
            stack.push(index ++);
        }
        return result;
    }
}
