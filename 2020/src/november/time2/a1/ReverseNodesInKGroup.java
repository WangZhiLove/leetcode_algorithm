package november.time2.a1;

public class ReverseNodesInKGroup {
    /**
     * 25. K 个一组翻转链表
     * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
     *
     * k 是一个正整数，它的值小于或等于链表的长度。
     *
     * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     *
     * 示例：
     *
     * 给你这个链表：1->2->3->4->5
     *
     * 当 k = 2 时，应当返回: 2->1->4->3->5
     *
     * 当 k = 3 时，应当返回: 3->2->1->4->5
     *
     * 说明：
     *
     * 你的算法只能使用常数的额外空间。
     * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     */

    public ListNode reverseKGroup(ListNode head, int k) {
        // 边界条件
        if (head == null || k == 1) {
            return head;
        }
        // 开始执行
        ListNode headNode = new ListNode(0);
        headNode.next = head;
        ListNode pre = headNode;
        ListNode end = head;
        int count = 0;
        while (end != null) {
            count ++;
            if (count % k != 0) {
                end = end.next;
                continue;
            }
            pre = reverseNode(pre, end.next);
            end = pre.next;
        }
        return headNode.next;
    }

    private ListNode reverseNode(ListNode pre, ListNode next) {
        // 交换节点
        ListNode last = pre.next;
        ListNode cur = last.next;
        while (cur != next) {
            ListNode temp = cur.next;
            // 第二个节点和第一个节点交换,永远是个pre.next节点来做操作，可以保证pre的下一个元素为next的前一个节点
            cur.next = pre.next;
            // 头结点指定交换后的头结点
            pre.next = cur;
            // 第三个节点为原第一个的下一个节点
            last.next = temp;
            // 当前节点为第三个节点
            cur = temp;
        }
        return last;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }