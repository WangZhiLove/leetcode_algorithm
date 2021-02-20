package day1.question1;

public class MaxConsecutiveOnesiii2 {
    //给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
    //
    // 返回仅包含 1 的最长（连续）子数组的长度。
    //
    // 示例 1：
    //
    // 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
    //输出：6
    //解释：
    //[1,1,1,0,0,1,1,1,1,1,1]
    //粗体数字从 0 翻转到 1，最长的子数组长度为 6。
    //
    // 示例 2：
    //
    // 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
    //输出：10
    //解释：
    //[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
    //粗体数字从 0 翻转到 1，最长的子数组长度为 10。
    //
    //
    //
    // 提示：
    //
    //
    // 1 <= A.length <= 20000
    // 0 <= K <= A.length
    // A[i] 为 0 或 1
    //
    // Related Topics 双指针 Sliding Window

    // 思路：该题目拿到手并没有思路，看了题解的思路，想想如何做
    // 解决思路就是滑动窗口，也叫双指针移动法，求最长的子数组长度，也就是左右指针中间的0的个数要小于等于k
    // 什么时候左指针移动  0的个数大于K
    // 什么时候右指针移动  0的个数小于K
    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }

    /**
     * 时间复杂度为 O(n)
     * 空间复杂度为 O(1)
     * @param A
     * @param K
     * @return
     */
    public static int longestOnes(int[] A, int K) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int result = 0;
        int left = 0;
        int right = 0;
        int zeroNum = 0;
        while (right < A.length) {
            if (A[right] == 0) {
                zeroNum ++;
            }
            while (zeroNum > K) {
                if (A[left ++] == 0) {
                    zeroNum --;
                }
            }
            result = Math.max(right - left + 1, result);
            right ++;
        }
        return result;
    }
    
}
