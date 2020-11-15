package november.time1.a11;

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
     * 这题目老师花了3分钟讲完，我也没懂，最后还是看了代码才懂
     * 其实就是转化成了前面的接雨水的题目，不过这道题是要求矩形的面积，如何转化才是关键
     *
     * 多声明一个二维数组用来保存高度，将每一行变成上方到当前行的高度，这样话最后计算每一行的最大值，再比较n行的最大值就可以了
     */

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int[][] arr = new int[matrix.length][matrix[0].length];
        // 转换成存储的高度
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == 0) {
                    arr[i][j] = matrix[i][j] == '0' ? 0 : 1;
                } else {
                    arr[i][j] = matrix[i][j] == '0' ? 0 : 1 + arr[i - 1][j];
                }
            }
        }
        int result = 0;
        // 计算面积
        for (int i = 0; i < arr.length; i++) {
            result = Math.max(result, maxArea(arr[i]));
        }
        return result;
    }

    private int maxArea(int[] heights) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        while (index < heights.length) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[index]) {
                stack.push(index ++);
            } else {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? index : index - stack.peek() - 1;
                result  = Math.max(result, height * width);
            }
        }
        // 这一点是与雨水题的唯一区别
        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            int width = stack.isEmpty() ? index : index - stack.peek() - 1;
            result  = Math.max(result, height * width);
        }
        return result;
    }
}
