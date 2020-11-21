package november.time1.a15;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SerializeAndDeserializeBinaryTree {

    /**
     * 297. 二叉树的序列化与反序列化
     * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
     *
     * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
     *
     * 示例:
     *
     * 你可以将以下二叉树：
     *
     *     1
     *    / \
     *   2   3
     *      / \
     *     4   5
     *
     * 序列化为 "[1,2,3,null,null,4,5]"
     * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
     *
     * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
     */

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 使用DFS
        String result = dfs(root, new StringBuilder());
        return result.substring(0, result.length() - 1);
    }

    private String dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        dfs(root.left, sb);
        dfs(root.right, sb);
        return sb.toString();
    }

    ///
    /*private String dfs(TreeNode root, String sb) {
        if (root == null) {
            sb.append("#,");
            return sb.toString();
        }
        sb += root.val + ",");
        sb = dfs(root.left, sb);
        sb = dfs(root.right, sb);
        return sb;
    }*/


    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        List<String> strings = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelp(strings);
    }

    private TreeNode deserializeHelp(List<String> strings) {
        if ("#".equals(strings.get(0))) {
            strings.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(strings.get(0)));
        strings.remove(0);
        root.left = deserializeHelp(strings);
        root.right = deserializeHelp(strings);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        TreeNode root3 = new TreeNode(4);
        TreeNode root4 = new TreeNode(5);
        root.left = root1;
        root.right = root2;
        root2.left = root3;
        root2.right = root4;
        SerializeAndDeserializeBinaryTree serializeAndDeserializeBinaryTree = new SerializeAndDeserializeBinaryTree();
        String serialize = serializeAndDeserializeBinaryTree.serialize(root);
        System.out.println(serialize);

        TreeNode deserialize = serializeAndDeserializeBinaryTree.deserialize(serialize);
        System.out.println(deserialize.val);
    }
}

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }