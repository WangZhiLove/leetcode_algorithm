package december.time1.a2;

import java.util.Arrays;

public class KthLargestElementInAnArray {
    /**
     * 215. 数组中的第K个最大元素
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     *
     * 示例 1:
     *
     * 输入: [3,2,1,5,6,4] 和 k = 2
     * 输出: 5
     * 示例 2:
     *
     * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
     * 输出: 4
     * 说明:
     *
     * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
     */
    /**
     * 先试试直接排序,利用了Java内置的排序，2ms
     */
    /*public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int kth = nums.length - k;
        return nums[kth];
    }*/

    /**
     * 下面这种13ms
     */
    public static int findKthLargest(int[] nums, int k) {
        return getkth(nums.length - k + 1, nums, 0, nums.length - 1);
    }

    private static int getkth(int k, int[] nums, int start, int end) {
        int pivot = nums[end];
        int left = start;
        int right = end;
        while(true) {
            while (nums[left] < pivot && left < right) {
                left ++;
            }
            while (nums[right] >= pivot && left < right) {
                right --;
            }
            if (left == right) {
                break;
            }
            swap(nums, left, right);
        }
        swap(nums, left, end);
        if (k == left + 1) {
            return pivot;
        } else if(k < left + 1) {
            return getkth(k, nums, start, left - 1);
        } else {
            return getkth(k, nums, left + 1, end);
        }
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }

}
