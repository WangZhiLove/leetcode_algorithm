package november.time1.a4;

import java.util.HashMap;

public class RemoveNthNodeFromEndOfList {
    /**
     * 19. 删除链表的倒数第N个节点
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     *
     * 示例：
     *
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     *
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * 说明：
     *
     * 给定的 n 保证是有效的。
     *
     * 进阶：
     *
     * 你能尝试使用一趟扫描实现吗？
     */

    /**
     * 一次哈希试试: 时间复杂度 O(n), 空间复杂度 O(n)
     *
     */
    /// 哈希表的做法
    /*public ListNode removeNthFromEnd(ListNode head, int n) {
        HashMap<Integer, ListNode> map = new HashMap<>();
        int count = 0;
        while (head != null) {
            map.put(count ++, head);
            head = head.next;
        }
        int index = count - n;
        if (index == 0) {
            return map.get(1);
        } else {
            ListNode listNode = map.get(index - 1);
            listNode.next = null;
            return map.get(0);
        }
    }*/
    /**
     * 双指针的做法
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 带头结点的声明,头结点的声明升了很多边界条件的判断
        ListNode preHeader = new ListNode(0, head);
        ListNode right = head;
        ListNode left = preHeader;
        for (int i = 0; i < n; i++) {
            right = right.next;
        }
        while (right != null) {
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return preHeader.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
