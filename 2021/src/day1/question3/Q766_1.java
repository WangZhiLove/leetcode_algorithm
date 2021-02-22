package day1.question3;

import java.util.Arrays;

public class Q766_1 {

    public static void main(String[] args) {
//        boolean toeplitzMatrix = isToeplitzMatrix(new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}});
        boolean toeplitzMatrix = isToeplitzMatrix(new int[][]{{1, 2}, {2, 1}});
        System.out.println(toeplitzMatrix);
    }

    /**
     * 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
     *
     * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
     */

    public static boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix != null && (matrix.length == 0 || matrix[0].length == 0)) {
            return true;
        }
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (!visited[i][j]) {
                    boolean toplitz = isToplitz(i, j, matrix, visited);
                    if (!toplitz) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean isToplitz(int i, int j, int[][] matrix, boolean[][] visited) {
        if (i + 1 < matrix.length && j + 1 < matrix[i + 1].length) {
            if (matrix[i][j] == matrix[i + 1][j + 1]) {
                visited[i][j] = true;
                return isToplitz(i + 1, j + 1, matrix, visited);
            }
        } else {
            return true;
        }
        return false;
    }
}
