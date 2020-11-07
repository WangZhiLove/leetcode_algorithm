package november.time2.a6;

public class RemoveDuplicatesFromSortedListII {
    /**
     * 82. 删除排序链表中的重复元素 II
     * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
     *
     * 示例 1:
     *
     * 输入: 1->2->3->3->4->4->5
     * 输出: 1->2->5
     * 示例 2:
     *
     * 输入: 1->1->1->2->3
     * 输出: 2->3
     */

    /**
     * 这道题目有了带头节点，啥都好说，所以说带头节点在链表数据结构的算法题目中是一个很重要的概念
     * 双指针的思路,遇到重复的先去掉，从重复后的第一个元素重新开始判断，有种递归的意思
     */

    /// 循环思路
    /*public ListNode deleteDuplicates(ListNode head) {
        ListNode preHeader = new ListNode(0);
        preHeader.next = head;
        ListNode left = preHeader;
        while (left.next != null && left.next.next != null) {
            if (left.next.val == left.next.next.val) {
                ListNode temp = left.next;
                while (temp != null && temp.next != null && temp.val == temp.next.val) {
                    temp = temp.next;
                }
                left.next = temp.next;
            } else {
                left = left.next;
            }
        }
        return preHeader.next;
    }*/

    /**
     * 递归思路
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val == head.next.val) {
            while (head != null && head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }
}

class ListNode {

    int val;

    ListNode next;

    ListNode(int x) { val = x; }

}