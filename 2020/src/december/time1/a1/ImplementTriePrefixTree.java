package december.time1.a1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImplementTriePrefixTree {
    /**
     * 208. 实现 Trie (前缀树)
     * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
     *
     * 示例:
     *
     * Trie trie = new Trie();
     *
     * trie.insert("apple");
     * trie.search("apple");   // 返回 true
     * trie.search("app");     // 返回 false
     * trie.startsWith("app"); // 返回 true
     * trie.insert("app");
     * trie.search("app");     // 返回 true
     * 说明:
     *
     * 你可以假设所有的输入都是由小写字母 a-z 构成的。
     * 保证所有输入均为非空字符串。
     */

    /**
     * 这道题目的关键其实在于TreeNode的声明
     */
    private TreeNode root;

    /** Initialize your data structure here. */
    public ImplementTriePrefixTree() {
        root = new TreeNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Map<Character, TreeNode> child = root.child;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TreeNode next;
            if (child.containsKey(c)) {
                next = child.get(c);
            } else {
                next = new TreeNode(c);
                child.put(c, next);
            }
            child = next.child;
            if (i == word.length() - 1) {
                next.end = true;
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode treeNode = searchTreeNode(word);
        if (treeNode != null && treeNode.end) {
            return true;
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeNode treeNode = searchTreeNode(prefix);
        if (treeNode == null) {
            return false;
        }
        // 如果treeNode是单词呢？也返回true？题目要求？
        return true;
    }
    
    public TreeNode searchTreeNode(String word) {
        Map<Character, TreeNode> child = root.child;
        TreeNode cur = null;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (child.containsKey(c)) {
                cur = child.get(c);
                child = cur.child;
            } else {
                return null;
            }
        }
        return cur;
    }
}

class TreeNode {
    char c;
    Map<Character, TreeNode> child = new HashMap<>();
    boolean end = false;

    public TreeNode() {
    }

    public TreeNode(char c) {
        this.c = c;
    }


    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }


    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }
}
