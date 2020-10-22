package october.time1.a11;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    /**
     * 划分字母区间
     *
     * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
     *
     *
     * 示例 1：
     *
     * 输入：S = "ababcbacadefegdehijhklij"
     * 输出：[9,7,8]
     * 解释：
     * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
     * 每个字母最多出现在一个片段中。
     * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
     *
     * 提示：
     *
     * S的长度在[1, 500]之间。
     * S只包含小写字母 'a' 到 'z' 。
     */

    /**
     * 贪心算法 + 双指针
     * 感觉要猝在双指针上
     */
    public static List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        int[] arr = new int[26];
        // a ~ z用int数组表示，很常用
        for (int i = 0; i < S.length(); i++) {
            arr[S.charAt(i) - 'a'] = i;
        }
        int start = 0, end = 0;
        for (int i = 0; i < S.length(); i++) {
            // 这里的判断比较巧妙
            end = Math.max(end, arr[S.charAt(i) - 'a']);
            // 说明重合
            if (i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = partitionLabels("ababcbacadefegdehijhklij");
        list.forEach(System.out::println);
    }
}
