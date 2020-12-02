package december.time2.a1;

import java.util.HashMap;
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

    TreeNode root;

    /** Initialize your data structure here. */
    public ImplementTriePrefixTree() {
        root = new TreeNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Map<Character, TreeNode> child = root.child;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TreeNode cur = null;
            if (child.containsKey(c)) {
                cur = child.get(c);
            } else {
                cur = new TreeNode(c);
                child.put(c, cur);
            }
            child = cur.child;
            if (i == word.length() - 1) {
                cur.isEnd = true;
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode treeNode = searchWord(word);
        if (treeNode != null && treeNode.isEnd) {
            return true;
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeNode treeNode = searchWord(prefix);
        if (treeNode == null) {
            return false;
        }
        return true;
    }
    
    public TreeNode searchWord(String word) {
        Map<Character, TreeNode> child = root.child;
        TreeNode result = null;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (child.containsKey(c)) {
                result = child.get(c);
            } else {
                return null;
            }
            child = result.child;
        }
        return result;
    }
}

class TreeNode {

    char c;

    Map<Character, TreeNode> child = new HashMap<>();

    boolean isEnd = false;

    public TreeNode() {
    }

    public TreeNode(char c) {
        this.c = c;
    }
}


