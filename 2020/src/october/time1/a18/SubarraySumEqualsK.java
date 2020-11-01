package october.time1.a18;

import java.util.Arrays;
import java.util.HashMap;

public class SubarraySumEqualsK {
    /**
     * 560. 和为K的子数组
     *
     * 给定一个整数数组和一个整数k，你需要找到该数组中和为k的连续的子数组的个数。
     *
     * 示例 1 :
     *
     * 输入:nums = [1,1,1], k = 2
     * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
     * 说明 :
     *
     * 数组的长度为 [1, 20,000]。
     * 数组中元素的范围是 [-1000, 1000] ，且整数k的范围是[-1e7, 1e7]。
     */

    /**
     * 暴力求解：O（n^2）
     * 通过前缀和求连续区间的和：preSum[i,j] = preSum[j + 1] - preSum[i],需要额外借助HashMap
     */

    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        // 初始化Map，这个就表示和k相等的有一个,key表示preSum，value表是和为preSum的子数组的个数
        // map存放前缀和，也就是preSum（i） = nums[0,i)
        map.put(0, 1);
        // preSum求解的是 preSum（j） = nums[0, j)
        int preSum = 0;
        int result = 0;
        for (int num : nums) {
            preSum += num;
            // k其实就是区间和
            if (map.containsKey(preSum - k)) {
                result += map.get(preSum - k);
            }
            /// map.put(preSum, map.getOrDefault(preSum, 0) + 1);
            // 这种if - else比上面的时间消耗要低点
            if (map.containsKey(preSum)) {
                map.put(preSum, map.get(preSum) + 1);
            } else {
                map.put(preSum, 1);
            }
        }
        return result;
    }
}
