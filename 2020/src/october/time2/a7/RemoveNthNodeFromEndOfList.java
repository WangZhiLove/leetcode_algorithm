package october.time2.a7;

public class RemoveNthNodeFromEndOfList {
    /**
     * 删除链表的倒数第N个节点
     *
     * 给定一个链表，删除链表的倒数第n个节点，并且返回链表的头结点。
     *
     * 示例：
     *
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     *
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * 说明：
     *
     * 给定的 n保证是有效的。
     *
     * 进阶：
     *
     * 你能尝试使用一趟扫描实现吗？
     */

    /**
     * 暴力求解：先遍历链表，保存索引和元素，之后第二次删除
     * 能不能使用linkedHashMao
     */

    public ListNode removeNthFromEnd(ListNode head, int n) {

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