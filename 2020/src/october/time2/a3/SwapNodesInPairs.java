package october.time2.a3;

public class SwapNodesInPairs {
    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     *
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     * 示例 1：
     *
     *
     * 输入：head = [1,2,3,4]
     * 输出：[2,1,4,3]
     * 示例 2：
     *
     * 输入：head = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：head = [1]
     * 输出：[1]
     */

    /**
     * 非递归写法
     * 迭代写法
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = new ListNode(-1);
        result.next = head;
        ListNode temp = result;
        while (temp.next != null && temp.next.next != null) {
            ListNode first = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            first.next = end.next;
            end.next = first;
            temp = first;
        }
        return result.next;
    }
    /**
     * 递归写法
     */
   /* public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode left = head;
        ListNode right = head.next;
        left.next = swapPairs(right.next);
        right.next = left;
        return right;
    }*/

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        ListNode listNode4 = swapNodesInPairs.swapPairs(listNode);
        System.out.println(listNode4.val);
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
