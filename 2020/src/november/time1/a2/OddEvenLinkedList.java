package november.time1.a2;

public class OddEvenLinkedList {

    /**
     * 328. 奇偶链表
     * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
     *
     * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
     *
     * 示例 1:
     *
     * 输入: 1->2->3->4->5->NULL
     * 输出: 1->3->5->2->4->NULL
     * 示例 2:
     *
     * 输入: 2->1->3->5->6->4->7->NULL
     * 输出: 2->3->6->7->1->5->4->NULL
     * 说明:
     *
     * 应当保持奇数节点和偶数节点的相对顺序。
     * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
     */

    /**
     * O(1) 的时间复杂度
     * O(n) 的空间复杂度
     * 这道题目的关键点在于奇偶指针的变化和带头节点，在原head链表上进行操作
     *
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 奇偶指针
        ListNode odd = head;
        ListNode event = head.next;
        // 头结点
        ListNode eventHead = event;
        while (event != null && event.next != null) {
            // 1 -> 2 -> 3 -> 4 -> null
            // head.next = head.next.next;
            // 1 -> 3 -> 4 -> null
            odd.next = event.next;
            // odd 为 3
            odd = odd.next;
            // 2 -> 4 -> null
            event.next = odd.next;
            // event 为 4
            event = event.next;
        }
        // 1 -> 3 -> 2 -> 4
        odd.next = eventHead;
        return head;
    }

}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }