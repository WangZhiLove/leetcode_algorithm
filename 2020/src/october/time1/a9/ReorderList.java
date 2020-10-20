package october.time1.a9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReorderList {

    /**
     * 重排链表
     * 给定一个单链表L：L0→L1→…→Ln-1→Ln ，
     * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
     *
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     * 示例1:
     *
     * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
     * 示例 2:
     *
     * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
     */

    // 遍历一遍，放在list中，然后在遍历一遍list

    public static ListNode reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        List<ListNode> listNodes = new ArrayList<>();
        while (head != null) {
            listNodes.add(head);
            head = head.next;
        }
        for (int i = 0; i < listNodes.size() / 2; i++) {
            listNodes.get(i).next = listNodes.get(listNodes.size() - (i + 1));
            listNodes.get(listNodes.size() - (i + 1)).next = listNodes.get(i + 1);
        }
        listNodes.get(listNodes.size() / 2).next = null;
        head = listNodes.get(0);
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        /*ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);*/
        node.next = node1;
       /* node1.next = node2;
        node2.next = node3;
        node3.next = node4;*/
        ListNode node5 = reorderList(node);
        System.out.println(node5.val);

    }
}

class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
