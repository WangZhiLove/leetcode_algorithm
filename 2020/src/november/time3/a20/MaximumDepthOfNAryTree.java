package november.time3.a20;

import java.util.List;

public class MaximumDepthOfNAryTree {
    /**
     * 559. N叉树的最大深度
     * 给定一个 N 叉树，找到其最大深度。
     *
     * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
     *
     * 例如，给定一个 3叉树 :
     *
     * 我们应返回其最大深度，3。
     *
     * 说明:
     *
     * 树的深度不会超过 1000。
     * 树的节点总不会超过 5000。
     * @param root
     * @return
     */

    public int maxDepth(Node root) {
        
        return 0;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
