package november.time1.a1;

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

    /**
     * 自己的思路是借助与其它数据结构，双端队列，这个的话就不符合题目要求了，常数的额外空间，
     * 那意味着只能在原来的数组上进行操作，不能使用额外的数据结构，这下难住我了。
     */

    public ListNode reverseKGroup(ListNode head, int k) {
        // 边界条件的判断
        if (head == null || k == 1) {
            return head;
        }
        // 开始流程
        ListNode fakeHeader = new ListNode(0);
        fakeHeader.next = head;
        // 开始节点
        ListNode pre = fakeHeader;
        // 结尾节点
        ListNode end = head;
        // 计数
        int count = 0;
        while (end != null) {
            count ++;
            if (count % k != 0) {
                end = end.next;
                continue;
            }
            // 反转两个节点
            pre = reverseNode(pre, end.next);
            end = pre.next;
        }

        return fakeHeader.next;
    }

    private ListNode reverseNode(ListNode pre, ListNode next) {
        ListNode last = pre.next;
        ListNode cur = last.next;
        // while循环的思路就是 都下一个节点都指向pre.next，就可以实现交换了
        // 聚合例子： 0 -> 1 -> 2 -> 3 -> 4,k是3的话，pre就是0，next就是4
        // 第一次while循环的结果： 0 -> 2 -> 1 -> 3 -> 4
        // 第二次： 0 -> 3 -> 2 -> 1 -> 4
        // 返回last，last从赋值开始就没有变化，就是1
        while (cur != next) {
            ListNode temp = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            last.next = temp;
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