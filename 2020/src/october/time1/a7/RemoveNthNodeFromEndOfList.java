package october.time1.a7;

import java.util.LinkedHashMap;

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
     * 能不能使用map  O(n)的时间复杂度和空间复杂度
     */

    /*public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        LinkedHashMap<Integer, ListNode> listNodeLinkedHashMap = new LinkedHashMap<>();
        int loop = 0;
        while (head != null) {
            listNodeLinkedHashMap.put(loop ++, head);
            head = head.next;
        }
        ListNode listNode = listNodeLinkedHashMap.get(listNodeLinkedHashMap.size() - n - 1);
        if (listNode != null) {
            listNode.next = listNodeLinkedHashMap.getOrDefault(listNodeLinkedHashMap.size() - n + 1, null);
            return listNodeLinkedHashMap.get(0);
        } else {
            return listNodeLinkedHashMap.get(1);
        }


    }*/

    /**
     * 官方优秀题解
     * 双指针移动法
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(0, head);
        ListNode first = head;
        ListNode second = temp;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return temp.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode listNode = removeNthFromEnd(head, 2);
        System.out.println(listNode.val);
    }
}

 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }