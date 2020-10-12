package october.time1.a2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MinimumAbsoluteDifferenceInBst {
    /**
     * 二叉搜索树的最小绝对差
     *
     * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
     *
     * 示例：
     *
     * 输入：
     *
     *    1
     *     \
     *      3
     *     /
     *    2
     *
     * 输出：
     * 1
     *
     * 解释：
     * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
     */

    int pre;
    int ans;
    /**
     * 因为是二叉搜索树，所以可以使用中序遍历来做
     * 中序遍历就直接是升序遍历
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public int getMinimumDifference(TreeNode root) {
        pre = -1;
        ans = Integer.MAX_VALUE;
        middleOrder(root);
        return ans;
    }

    private void middleOrder(TreeNode root) {
        if (root == null) {
            return ;
        }
        middleOrder(root.left);
        if (pre != -1) {
           ans = Math.min(ans, root.val - pre);
        }
        pre = root.val;
        middleOrder(root.right);

    }

    /**
     * bfs和dfs都可以实现
     * 题目理解错误，重新来过，任意两个节点，而不是子父节点
     * 那这个先遍历存储，然后排个序，我觉得会简单
     * 这个就是强行做了，有更简单的方法，直接中序遍历就好
     */
    /*public int getMinimumDifference(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        while (!linkedList.isEmpty()) {
            int loop = linkedList.size();
            for (int i = 0; i < loop; i++) {
                TreeNode treeNode = linkedList.pollFirst();
                list.add(treeNode.val);
                if (treeNode.left != null) {
                    linkedList.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    linkedList.add(treeNode.right);
                }
            }
        }
        list.sort(Comparator.comparingInt(o -> o));
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            result = Math.min(result, list.get(i + 1) - list.get(i));
        }
        return result;
    }*/



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(2);
        root.right = left;
        left.left = right;

    }
}


 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }