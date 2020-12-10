package december.time3.a4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class WiggleSortii {
    /**
     * 324. 摆动排序 II
     * 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
     *
     * 示例 1:
     *
     * 输入: nums = [1, 5, 1, 1, 6, 4]
     * 输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6]
     * 示例 2:
     *
     * 输入: nums = [1, 3, 2, 2, 3, 1]
     * 输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2]
     * 说明:
     * 你可以假设所有输入都会得到有效的结果。
     */

    /**
     * 和前一个的不同点在于相邻两个不能是一样的数字，那就排序二分法，然后为了保证相邻不能在一起，所以两边逆序之后在进行交叉插入数组
     */

    public static void wiggleSort(int[] nums) {
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        int middleIndex = (int) Math.ceil(temp.length / 2.0);
        int[] left = Arrays.copyOfRange(temp, 0, middleIndex);
        int[] right = Arrays.copyOfRange(temp, middleIndex, temp.length);
        int leftIndex = left.length - 1;
        int rightIndex = right.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = left[leftIndex --];
            } else {
                nums[i] = right[rightIndex --];
            }
        }


    }

    public static void main(String[] args) {
        int[] temp = new int[]{1,1,2,1,2,2,1};
        wiggleSort(temp);
    }
}
