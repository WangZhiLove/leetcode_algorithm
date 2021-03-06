package october.time1.a16;

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

    /**
     * 有思路也没做出来：
     * 1。 暴力求解，时间复杂度 O(n^2)
     * 2。 双指针法，时间复杂度 O(n)
     *
     * 要想知道一个程序为什么错，就必须要知道一个程序为什么对！！！
     */

    public static int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= s && left < right) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left ++];
            }
            right ++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));

    }
}
