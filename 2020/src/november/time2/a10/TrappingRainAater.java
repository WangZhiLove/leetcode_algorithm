package november.time2.a10;

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
     * 对称内容，就找栈结构
     */
    public int trap(int[] height) {
        // 边界条件的判断
        if (height == null || height.length == 0) {
            return 0;
        }
        // 栈结构和存在数组
        int result = 0;
        int len = height.length;
        Stack<Integer> stack = new Stack<>();
        boolean[] exists = new boolean[len];
        int index = 0;
        while (index < len) {
            while (!stack.isEmpty() && height[index] > height[stack.peek()]) {
                int height1 = height[stack.pop()];
                if (stack.isEmpty()) {
                    break;
                }
                int width = index - stack.peek() - 1;
                result += (Math.min(height[index], height[stack.peek()]) - height1) * width;
            }
            stack.push(index ++);
        }
        /// 使用while循环是不是更简单
        /*for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int height1 = height[stack.pop()];
                if (stack.isEmpty()) {
                    break;
                }
                int height2 = height[stack.peek()];
                int width = i - stack.peek() - 1;
                result += (Math.min(height[i], height2) - height1) * width;
            }
            stack.push(i);
        }*/
        return result;
    }
}
