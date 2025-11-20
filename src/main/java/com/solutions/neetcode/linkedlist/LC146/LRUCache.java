package com.solutions.neetcode.linkedlist.LC146;

import java.util.HashMap;

class LRUCache {

    class Node {
        int key;
        int val;
        Node next;
        Node prev;
        Node(int k, int v) { key = k; val = v; }
    }

    private final HashMap<Integer, Node> nodeMap;
    private Node head, tail;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>();
        head = null;
        tail = null;
    }

    public int get(int key) {
        if (!nodeMap.containsKey(key)) return -1;
        Node node = nodeMap.get(key);
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            node.val = value;
            moveToHead(node);
            return;
        }

        Node node = new Node(key, value);
        nodeMap.put(key, node);
        addToHead(node);

        if (nodeMap.size() > capacity) {
            nodeMap.remove(tail.key);
            removeTail();
        }
    }

    private void addToHead(Node node) {
        node.prev = null;
        node.next = head;
        if (head != null) head.prev = node;
        head = node;
        if (tail == null) tail = node;
    }

    private void moveToHead(Node node) {
        if (node == head) return;
        if (node.prev != null) node.prev.next = node.next;
        if (node.next != null) node.next.prev = node.prev;
        if (node == tail) tail = node.prev;
        addToHead(node);
    }

    private void removeTail() {
        if (tail == null) return;
        if (tail.prev != null) tail.prev.next = null;
        else head = null;
        tail = tail.prev;
    }
}

