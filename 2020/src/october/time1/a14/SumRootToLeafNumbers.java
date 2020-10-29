package october.time1.a14;

import java.util.LinkedList;
import java.util.List;

public class SumRootToLeafNumbers {

    /**
     * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
     *
     * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
     *
     * 计算从根到叶子节点生成的所有数字之和。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例 1:
     *
     * 输入: [1,2,3]
     *     1
     *    / \
     *   2   3
     * 输出: 25
     * 解释:
     * 从根到叶子节点路径 1->2 代表数字 12.
     * 从根到叶子节点路径 1->3 代表数字 13.
     * 因此，数字总和 = 12 + 13 = 25.
     * 示例 2:
     *
     * 输入: [4,9,0,5,1]
     *     4
     *    / \
     *   9   0
     *  / \
     * 5   1
     * 输出: 1026
     * 解释:
     * 从根到叶子节点路径 4->9->5 代表数字 495.
     * 从根到叶子节点路径 4->9->1 代表数字 491.
     * 从根到叶子节点路径 4->0 代表数字 40.
     * 因此，数字总和 = 495 + 491 + 40 = 1026.
     */

    /**
     * 直接深度遍历
     */
    static int result = 0;

    public static int sumNumbers(TreeNode root) {
        if (root == null) {
            return result;
        }
        dfs(root, 0);
        return result;
    }

    /**
     * 时间复杂度 O(2^n)
     * 空间复杂度 O(树的深度)，其实就是方法调用栈的深度
     */
    private static void dfs(TreeNode root, int sum) {
        // 终止条件
        if (root.left == null && root.right == null) {
            result += (sum * 10 + root.val);
            return ;
        }
        sum = sum * 10 + root.val;
        if (root.left != null) {
            dfs(root.left, sum);
        }
        if (root.right != null) {
            dfs(root.right, sum);
        }
        sum /= 10;
    }

   /* public static int sumNumbers(TreeNode root) {
        if (root == null) {
            return result;
        }
        LinkedList<Integer> list = new LinkedList<>();
        dfs(root, list);
        return result;
    }

    *//**
     * 时间复杂度 O(2^n)
     * 空间复杂度 O(树的深度)，其实就是方法调用栈的深度
     *//*
    private static void dfs(TreeNode root, LinkedList<Integer> list) {
        // 终止条件
        if (root.left == null && root.right == null) {
            int num = 0;
            for (Integer temp : list) {
               num = num * 10 + temp;
            }
            result += (num * 10 + root.val);
            return ;
        }
        list.add(root.val);
        if (root.left != null) {
            dfs(root.left, list);
        }
        if (root.right != null) {
            dfs(root.right, list);
        }
        list.pollLast();
    }*/

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        TreeNode treeNode1 = new TreeNode(9);
        TreeNode treeNode2 = new TreeNode(0);
        treeNode.left  = treeNode1;
        treeNode.right  = treeNode2;
        TreeNode treeNode3 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(1);
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        System.out.println(sumNumbers(treeNode));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
