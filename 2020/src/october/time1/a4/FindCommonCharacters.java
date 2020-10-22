package october.time1.a4;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FindCommonCharacters {
    /**
     * 查找常用字符
     *
     * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
     *
     * 你可以按任意顺序返回答案。
     *
     *
     * 示例 1：
     *
     * 输入：["bella","label","roller"]
     * 输出：["e","l","l"]
     * 示例 2：
     *
     * 输入：["cool","lock","cook"]
     * 输出：["c","o"]
     *
     * 提示：
     *
     * 1 <= A.length <= 100
     * 1 <= A[i].length <= 100
     * A[i][j] 是小写字母
     */

    public static List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        String str = A[0];
        for (char c : str.toCharArray()) {
            int sum = 1;
            for (int i = 1; i < A.length; i++) {
                int index = A[i].indexOf(c);
                if ( index != -1) {
                    StringBuilder sb = new StringBuilder(A[i]);
                    sb.replace(index, index + 1, "");
                    A[i] = sb.toString();
                    sum ++;
                }
            }
            if (sum == A.length) {
                result.add(String.valueOf(c));
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        List<String> strings = commonChars(new String[]{"bella", "label", "roller"});
        List<String> strings = commonChars(new String[]{"cool","lock","cook"});
        strings.forEach(System.out::println);
    }
}
