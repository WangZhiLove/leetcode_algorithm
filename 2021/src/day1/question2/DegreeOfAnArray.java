package day1.question2;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray {

    public static void main(String[] args) {
        System.out.println(findShortestSubArray(new int[]{1,2,2,3,1}));
    }

    /**
     * 给定一个非空且只包含非负数的整数数组nums，数组的度的定义是指数组里任一元素出现频数的最大值。
     *
     * 你的任务是在 nums 中找到与nums拥有相同大小的度的最短连续子数组，返回其长度。
     *
     *
     *
     * 示例 1：
     *
     * 输入：[1, 2, 2, 3, 1]
     * 输出：2
     * 解释：
     * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
     * 连续子数组里面拥有相同度的有如下所示:
     * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
     * 最短连续子数组[2, 2]的长度为2，所以返回2.
     * 示例 2：
     *
     * 输入：[1,2,2,3,1,4,2]
     * 输出：6
     *
     *
     * 提示：
     *
     * nums.length在1到 50,000 区间范围内。
     * nums[i]是一个在 0 到 49,999 范围内的整数。
     */

    public static int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        int maxNum = 0;
        Map<Integer, int[]> map = new HashMap<>();
        // 遍历数组，统计每一个元素出现的次数和开始索引以及结尾索引
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int[] ints = map.get(nums[i]);
                ints[0] ++;
                ints[2] = i;
                maxNum = Math.max(maxNum, ints[0]);
            } else {
                map.put(nums[i], new int[]{1, i, i});
                maxNum = Math.max(maxNum, 1);
            }
        }
        // 遍历Map，计算最后的结果
        for (Map.Entry<Integer, int[]> integerEntry : map.entrySet()) {
            int[] value = integerEntry.getValue();
            if (value[0] == maxNum) {
                result = Math.min(result, value[2] - value[1] + 1);
            }
        }
        return result;
    }
}
