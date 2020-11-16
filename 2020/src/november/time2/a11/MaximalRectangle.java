package november.time2.a11;

import java.util.Stack;

public class MaximalRectangle {
    /**
     * 85. 最大矩形
     *
     * 给定一个仅包含0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
     *
     * 示例 1：
     *
     *
     * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
     * 输出：6
     * 解释：最大矩形如上图所示。
     * 示例 2：
     *
     * 输入：matrix = []
     * 输出：0
     * 示例 3：
     *
     * 输入：matrix = [["0"]]
     * 输出：0
     * 示例 4：
     *
     * 输入：matrix = [["1"]]
     * 输出：1
     * 示例 5：
     *
     * 输入：matrix = [["0","0"]]
     * 输出：0
     *
     * 提示：
     *
     * rows == matrix.length
     * cols == matrix.length
     * 0 <= row, cols <= 200
     * matrix[i][j] 为 '0' 或 '1'
     */

    /**
     * 这个得换种思路思考，就是进行题意转化，转化成接雨水题目，只不过这里要计算不是雨水的面积，还是下面实体的面积
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int[][] heights = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == 0) {
                    heights[i][j] = matrix[i][j] == '0' ? 0 : 1;
                } else {
                    heights[i][j] = matrix[i][j] == '0' ? 0 : heights[i - 1][j] + 1;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            result = Math.max(result, heightArea(heights[i]));
        }
        return result;
    }

    private int heightArea(int[] height) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        while (index < height.length) {
            if (stack.isEmpty() || height[index] <= height[stack.peek()]) {
                stack.push(index ++);
            } else {
                int height2 = height[stack.pop()];
                int width = stack.isEmpty() ? index : index - stack.peek() - 1;
                result = Math.max(result, height2 * width);
            }
        }
        while (!stack.isEmpty()) {
            int height2 = height[stack.pop()];
            int width = stack.isEmpty() ? index : index - stack.peek() - 1;
            result = Math.max(result, height2 * width);
        }

        return result;
    }
}
