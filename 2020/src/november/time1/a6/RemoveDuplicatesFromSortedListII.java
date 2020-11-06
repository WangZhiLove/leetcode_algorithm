package november.time1.a6;

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
     * 时间复杂度是 O(n)的
     */

    /**
     * 有没有更贱简单的写法
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode preHeader = new ListNode(0);
        preHeader.next = head;
        ListNode temp = preHeader;
        // 计数
        int count = 0;
        while (head != null && head.next != null) {
            if (head.val != head.next.val) {
                if (count == 0) {
                    temp.next = head;
                    temp = temp.next;
                }
                count = 0;
            } else {
                count ++;
            }
            head = head.next;
        }
        if (count == 0) {
            temp.next = head;
        } else {
            temp.next = null;
        }
        return preHeader.next;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode root1 = new ListNode(1);
        ListNode root2 = new ListNode(1);
        ListNode root3 = new ListNode(2);
        ListNode root4 = new ListNode(3);
        /*ListNode root = new ListNode(1);
        ListNode root1 = new ListNode(2);
        ListNode root2 = new ListNode(3);
        ListNode root3 = new ListNode(3);
        ListNode root4 = new ListNode(4);*/
        root.next = root1;
        root1.next = root2;
        root2.next = root3;
        root3.next = root4;
        RemoveDuplicatesFromSortedListII removeDuplicatesFromSortedListII = new RemoveDuplicatesFromSortedListII();
        ListNode listNode = removeDuplicatesFromSortedListII.deleteDuplicates(root);
        System.out.println(listNode.val);
    }
}

class ListNode {

    int val;

    ListNode next;

    ListNode(int x) { val = x; }

}