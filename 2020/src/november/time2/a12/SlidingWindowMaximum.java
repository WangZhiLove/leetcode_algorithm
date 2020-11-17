package november.time2.a12;

import java.util.LinkedList;
import java.util.Stack;

public class SlidingWindowMaximum {
    /**
     * 239. 滑动窗口最大值
     * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     *
     * 返回滑动窗口中的最大值。
     *
     * 进阶：
     *
     * 你能在线性时间复杂度内解决此题吗？
     *
     * 示例:
     *
     * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
     * 输出: [3,3,5,5,6,7]
     * 解释:
     *
     *   滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 10^5
     * -10^4 <= nums[i] <= 10^4
     * 1 <= k <= nums.length
     */

    /**
     * 昨天提交的是使用双端队列结构来进行窗口的移动，回忆一下
     */

    /// 昨天的回忆
    /*public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] result = new int[nums.length - k + 1];
        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            if (i - k + 1 >= 0) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }*/

    /**
     * 更简单的写法
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] result = new int[nums.length - k + 1];
        int loop = nums.length - k + 1;
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < loop; i++) {
            if (maxIndex >= i) {
                if (max < nums[i + k - 1]) {
                    max = nums[i + k - 1];
                    maxIndex = i + k - 1;
                }
                result[i] = max;
            } else {
                max = nums[i];
                for (int i1 = i + 1; i1 < k + i; i1++) {
                    if (max < nums[i1]) {
                        max = nums[i1];
                        maxIndex = i1;
                    }
                }
                result[i] = max;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        slidingWindowMaximum.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
    }
}
