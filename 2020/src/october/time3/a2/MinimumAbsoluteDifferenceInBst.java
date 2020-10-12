package october.time3.a2;

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

    /**
     * 因为是二叉搜索树，所以可以使用中序遍历来做
     * 中序遍历就直接是升序遍历
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public int getMinimumDifference(TreeNode root) {
        return 0;
    }





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