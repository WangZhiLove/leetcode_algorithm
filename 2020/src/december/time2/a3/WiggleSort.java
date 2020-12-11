package december.time2.a3;

public class WiggleSort {
    /**
     * 280. 摆动排序
     * 给你一个无序的数组 nums, 将该数字 原地 重排后使得 nums[0] <= nums[1] >= nums[2] <= nums[3]...。
     *
     * 示例:
     *
     * 输入: nums = [3,5,2,1,6,4]
     * 输出: 一个可能的解答是 [3,5,1,6,2,4]
     */

    /**
     * 奇数索引大于前一个索引的数字
     * 偶数索引小于前一个索引的数字
     * 不满足以上要求就交换
     */
    public void wiggleSort(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return ;
        }
        for (int i = 1; i < nums.length; i++) {
            if ((i % 2 == 1 && nums[i] < nums[i - 1]) || (i % 2 == 0 && nums[i] >nums[i - 1])) {
                int temp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;
            }
        }
    }
}
