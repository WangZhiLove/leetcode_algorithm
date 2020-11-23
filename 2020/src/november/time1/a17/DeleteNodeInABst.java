package november.time1.a17;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.TreeMap;

public class DeleteNodeInABst {
    /**
     * 450. 删除二叉搜索树中的节点
     * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
     *
     * 一般来说，删除节点可分为两个步骤：
     *
     * 首先找到需要删除的节点；
     * 如果找到了，删除它。
     * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
     *
     * 示例:
     *
     * root = [5,3,6,2,4,null,7]
     * key = 3
     *
     *     5
     *    / \
     *   3   6
     *  / \   \
     * 2   4   7
     *
     * 给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
     *
     * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
     *
     *     5
     *    / \
     *   4   6
     *  /     \
     * 2       7
     *
     * 另一个正确答案是 [5,2,6,null,4,null,7]。
     *
     *     5
     *    / \
     *   2   6
     *    \   \
     *     4   7
     */

    /**
     * 重点在于找到节点之后怎么替换，两种解决方案，找到左子树的最大值，或者找到右子树的最小值，进行替换
     */

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null && root.right == null) {
                root = null;
            }  else if (root.right != null) {
                // 找到替换之后，删除叶子节点
                root.val = replaceRightTree(root);
                root.right = deleteNode(root.right, root.val);
            } else {
                root.val = replaceLeftTree(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    private int replaceLeftTree(TreeNode treeNode) {
        TreeNode left = treeNode.left;
        while (left.right != null) {
            left = left.right;
        }
        return left.val;
    }

    private int replaceRightTree(TreeNode treeNode) {
        TreeNode right = treeNode.right;
        while (right.left != null) {
            right = right.left;
        }
        return right.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode root1 = new TreeNode(3);
        TreeNode root2 = new TreeNode(6);
        TreeNode root3 = new TreeNode(2);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(7);
        root.left = root1;
        root.right = root2;
        root1.left = root3;
        root1.right = root4;
        root2.right = root5;
        DeleteNodeInABst deleteNodeInABst = new DeleteNodeInABst();
        TreeNode treeNode = deleteNodeInABst.deleteNode(root, 3);
        System.out.println(treeNode.val);
    }
}

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
