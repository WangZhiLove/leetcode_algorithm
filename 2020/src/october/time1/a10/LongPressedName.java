package october.time1.a10;

import java.util.Collection;
import java.util.LinkedList;

public class LongPressedName {
    /**
     * 长按键入
     *
     * 你的朋友正在使用键盘输入他的名字name。偶尔，在键入字符c时，按键可能会被长按，而字符可能被输入 1 次或多次。
     *
     * 你将会检查键盘输入的字符typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回True。
     *
     *
     *
     * 示例 1：
     *
     * 输入：name = "alex", typed = "aaleex"
     * 输出：true
     * 解释：'alex' 中的 'a' 和 'e' 被长按。
     * 示例 2：
     *
     * 输入：name = "saeed", typed = "ssaaedd"
     * 输出：false
     * 解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
     * 示例 3：
     *
     * 输入：name = "leelee", typed = "lleeelee"
     * 输出：true
     * 示例 4：
     *
     * 输入：name = "laiden", typed = "laiden"
     * 输出：true
     * 解释：长按名字中的字符并不是必要的。
     *
     * 提示：
     *
     * name.length <= 1000
     * typed.length <= 1000
     * name 和typed的字符都是小写字母。
     */

    // 空间复杂度和时间复杂度都很高
    /*public static boolean isLongPressedName(String name, String typed) {
        char[] chars = name.toCharArray();
        char[] chars1 = typed.toCharArray();
        LinkedList<Character> nameLinked = new LinkedList<>();
        LinkedList<Character> typeLinked = new LinkedList<>();
        for (char aChar : chars) {
            nameLinked.add(aChar);
        }
        for (char c : chars1) {
            typeLinked.add(c);
        }
        char pre = 0;
        while (!nameLinked.isEmpty() || !typeLinked.isEmpty()) {
            char temp;
            if (nameLinked.isEmpty()) {
                temp = pre;
            } else {
                temp = nameLinked.peekFirst();
            }
            Character character = typeLinked.pollFirst();
            if (character == null) {
                return false;
            } else {
                if (character == temp) {
                    pre = nameLinked.isEmpty() ? pre : nameLinked.pollFirst();
                } else if (character != pre){
                    return false;
                }
            }


        }
        return true;
    }*/

    /**
     * 双指针法，有待学习
     * 时间复杂度 O(m + n)
     * 空间复杂度 O(1)
     */
    public static boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i ++;
                j ++;
            } else if (i > 0 && typed.charAt(j) == name.charAt(i - 1)) {
                j ++;
            } else {
                return false;
            }

        }
        return i == name.length();
    }

    public static void main(String[] args) {

         System.out.println(isLongPressedName("alex","aaleex"));
         System.out.println(isLongPressedName("saeed","ssaaedd"));
         System.out.println(isLongPressedName("leelee","lleeelee"));
         System.out.println(isLongPressedName("laiden","laiden"));
         System.out.println(isLongPressedName("vtkgn","vttkgnn"));
        System.out.println(isLongPressedName("pyplrz","ppyypllr"));
    }
}
