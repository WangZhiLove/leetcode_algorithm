package october.time1.a12;

import java.util.LinkedList;

public class PalindromeLinkedList {
    /**
     * 回文链表
     *
     * 请判断一个链表是否为回文链表。
     *
     * 示例 1:
     *
     * 输入: 1->2
     * 输出: false
     * 示例 2:
     *
     * 输入: 1->2->2->1
     * 输出: true
     * 进阶：
     * 你能否用O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     */

    /**
     * 脑海里面第一个想法：龟兔赛跑，双指针移动法，看看有没有能不能相等
     * 题意没看懂，回文的意思其实是对称
     * 这样的话双端队列就很合适
     */

    public static boolean isPalindrome(ListNode head) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        while (head != null) {
            linkedList.add(head.val);
            head = head.next;
        }
        while (!(linkedList.isEmpty() || linkedList.size() == 1)) {
            Integer integer = linkedList.pollFirst();
            Integer integer1 = linkedList.pollLast();
            if (!integer.equals(integer1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        /*ListNode root = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(2);
        root.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = root;
        System.out.println(isPalindrome(root));*/
        ListNode root = new ListNode(-129);
        ListNode root1 = new ListNode(-129);
        root.next = root1;
        System.out.println(isPalindrome(root));
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
