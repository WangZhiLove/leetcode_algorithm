package november.time1.a3;

import java.util.HashMap;

public class LRUCache {
    /**
     * 运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。
     * 146. 实现 LRUCache 类：
     *
     * LRUCache(int capacity) 以正整数作为容量capacity 初始化 LRU 缓存
     * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
     * void put(int key, int value)如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
     *
     *
     * 进阶：你是否可以在O(1) 时间复杂度内完成这两种操作？
     *
     */
    /**
     * 题目要求：
     * 1. 固定大小
     * 2. 插入和查询的效率需要高     -> HashMap
     * 3. 缓存超过界限删除不常用的   -> 双向链表用来删除元素就很快
     * 所以说使用的数据结构就是 HashMap + 双向链表
     */

    HashMap<Integer, Node> map = new HashMap<>();

    int capacity = 0;

    Node head = null;

    Node end = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeNode(node);
            setHeader(node);
            return node.value;
        }
        return -1;
    }

    private void setHeader(Node node) {
        if (head != null) {
            head.pre = node;
        }
        node.next = head;
        node.pre = null;
        head = node;
        // 维护尾结点
        if (end == null) {
            end = head;
        }
    }

    private void removeNode(Node node) {
        // 维护next指针
        if (node.pre != null) {
            node.pre.next = node.next;
        } else {
            // 说明删除的是头节点
            head = node.next;
        }
        // 维护pre指针
        if (node.next != null) {
            node.next.pre = node.pre;
        } else {
            end = node.pre;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            removeNode(node);
            setHeader(node);
        } else {
            Node node = new Node(key, value);
            if (capacity == map.size()) {
                map.remove(end.key);
                removeNode(end);
            }
            setHeader(node);
            map.put(key, node);
        }
    }
}

class Node {

    /**
     * 这个key我感觉可以不要，可能有我不知道的原因在吧
     */
    Integer key;

    Integer value;

    Node pre;

    Node next;

    public Node(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}