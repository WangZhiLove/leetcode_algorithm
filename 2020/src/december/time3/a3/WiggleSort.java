package december.time3.a3;

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
     * 这道题目我的想法非常复杂，就不多说了。
     * 老师的想法非常简单，从第一个奇数索引开始，当前数字大于前一个数字，如果不大，交换；接着是奇数后的偶数索引值要小于前一个数字，否则交换
     */
    public void wiggleSort(int[] nums) {
        if (nums.length <= 1) {
            return ;
        }
        for (int i = 1; i < nums.length; i++) {
            if ((i % 2 == 1 && nums[i] < nums[i - 1]) || (i % 2 == 0 && nums[i] > nums[i - 1])) {
                int temp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;
            }
        }
    }
}
