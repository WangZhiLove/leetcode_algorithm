package november.time2.a19;

import sun.nio.cs.ext.MacDingbat;

import java.util.Arrays;

public class ConstructBinarySearchTreeFromPreorderTraversal {
    /**
     * 1008. 前序遍历构造二叉搜索树
     * 返回与给定前序遍历 preorder 相匹配的二叉搜索树（binary search tree）的根结点。
     *
     * (回想一下，二叉搜索树是二叉树的一种，其每个节点都满足以下规则，对于 node.left 的任何后代，值总 < node.val，而 node.right 的任何后代，值总 > node.val。此外，前序遍历首先显示节点 node 的值，然后遍历 node.left，接着遍历 node.right。）
     *
     * 题目保证，对于给定的测试用例，总能找到满足要求的二叉搜索树。
     *
     *
     *
     * 示例：
     *
     * 输入：[8,5,1,7,10,12]
     * 输出：[8,5,10,1,7,null,12]
     *
     *
     *
     * 提示：
     *
     * 1 <= preorder.length <= 100
     * 1 <= preorder[i] <= 10^8
     * preorder 中的值互不相同
     */

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int leftIndex = -1;
        int rightIndex = -1;
        for (int i = 1; i < preorder.length; i++) {
            if (root.val < preorder[i]) {
                rightIndex = i;
                break;
            } else {
                leftIndex = i;
            }
        }
        if (leftIndex != -1) {
            root.left = bstFromPreorder(Arrays.copyOfRange(preorder, 1, leftIndex + 1));
        }
        if (rightIndex != -1) {
            root.right = bstFromPreorder(Arrays.copyOfRange(preorder, rightIndex, preorder.length));
        }
        return root;
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
