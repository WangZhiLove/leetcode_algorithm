package october.time1;

import java.util.*;

public class CircularLinkedList {

    /**
     * 给定一个链表，判断链表中是否有环。
     *
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表
     * 中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     *
     * 如果链表中存在环，则返回 true 。 否则，返回 false 。
     *
     *
     *
     * 进阶：
     *
     * 你能用 O(1)（即，常量）内存解决此问题吗？
     */
    /**
     * 使用map的数据结构
     */
    /// 时间复杂度和空间复杂度都是O(n)
    /*public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        int pos = -1;
        ListNode temp = head;
        Map<ListNode, Integer> map = new HashMap<>();
        int loop = 0;
        while (temp != null && !map.containsKey(temp)) {
            map.put(temp, loop ++);
            temp = temp.next;
        }
        if (temp != null && map.containsKey(temp)) {
            pos = map.get(temp);
        }
        return pos != -1;
    }*/

    /**
     * 利用哈希表的思路
     */
    /*public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }*/

    /**
     * 快慢指针，龟兔赛跑
     * 这道题目的时间复杂度是不可能减少的，都是O(n)
     * 空间复杂度就看使用的逻辑和思路，这种快慢组合就是O(1)的，没有使用到额外的数据结构
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val &&
                Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}