package october.time2.a16;

public class MinimumSizeSubarraySum {
    /**
     * 209. 长度最小的子数组
     *
     * 给定一个含有n个正整数的数组和一个正整数s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
     *
     *
     *
     * 示例：
     *
     * 输入：s = 7, nums = [2,3,1,2,4,3]
     * 输出：2
     * 解释：子数组[4,3]是该条件下的长度最小的子数组。
     *
     *
     * 进阶：
     *
     * 如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
     *
     */

    /*
    双指针
     */

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        int left = -1;
        int right = 0;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= s) {
                result = Math.min(result, right - left);
                sum -= nums[++ left];
            }
            right ++;
        }
        // 考虑特殊情况
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
