package october.time1.a6;

import java.util.Arrays;

public class SquaresOfASortedArra {

    /**
     * 有序数组的平方
     *
     * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
     *
     *
     *
     * 示例 1：
     *
     * 输入：[-4,-1,0,3,10]
     * 输出：[0,1,9,16,100]
     * 示例 2：
     *
     * 输入：[-7,-3,2,3,11]
     * 输出：[4,9,9,49,121]
     *
     *
     * 提示：
     *
     * 1 <= A.length <= 10000
     * -10000 <= A[i] <= 10000
     * A已按非递减顺序排序。
     */

    /**
     * 先平方，在排序，这样的时间复杂度就是 O（n log n）
     * 空间复杂度 O（1）
     */

    /*public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }*/

    /**
     * 双指针法，但是但是需要额外的内存空间
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public int[] sortedSquares(int[] A) {
        int[] result = new int[A.length];
        int index = result.length - 1;
        for (int i = 0, j = A.length - 1; j >= i;) {
            if (A[i] * A[i] > A[j] * A[j]) {
                result[index --] = A[i] * A[i];
                i ++;
            } else {
                result[index --] = A[j] * A[j];
                j --;
            }
        }
        return result;
    }
}
