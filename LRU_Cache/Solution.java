package com.company;

import java.util.*;

/**
 Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

 Implement the LRUCache class:

 LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 int get(int key) Return the value of the key if the key exists, otherwise return -1.
 void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 Follow up:
 Could you do get and put in O(1) time complexity?



 Example 1:

 Input
 ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 Output
 [null, null, null, 1, null, -1, null, -1, 3, 4]

 Explanation
 LRUCache lRUCache = new LRUCache(2);
 lRUCache.put(1, 1); // cache is {1=1}
 lRUCache.put(2, 2); // cache is {1=1, 2=2}
 lRUCache.get(1);    // return 1
 lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 lRUCache.get(2);    // returns -1 (not found)
 lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 lRUCache.get(1);    // return -1 (not found)
 lRUCache.get(3);    // return 3
 lRUCache.get(4);    // return 4
 */


class LRUCache {

    class DoubleLinkedListNode {
        private DoubleLinkedListNode pre;
        private DoubleLinkedListNode next;
        private int key;
        private int value;

        public DoubleLinkedListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return this.key;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }

        public void setPre(DoubleLinkedListNode node) {
            this.pre = node;
        }

        public void setNext(DoubleLinkedListNode node) {
            this.next = node;
        }

        public DoubleLinkedListNode getPre() {
            return this.pre;
        }

        public DoubleLinkedListNode getNext() {
            return this.next;
        }
    }

    private DoubleLinkedListNode head;
    private DoubleLinkedListNode tail;
    private Map<Integer, DoubleLinkedListNode> cache;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
    }

    public int get(int key) {
        DoubleLinkedListNode node = this.cache.get(key);
        if (node == null) {
            return -1;
        } else {
            // move the node to head
            moveNodeToHead(node);
            return node.getValue();
        }
    }

    public void put(int key, int value) {
        DoubleLinkedListNode node = this.cache.get(key);
        if(node != null) {
            node.setValue(value);
            moveNodeToHead(node);
        } else {
            node = new DoubleLinkedListNode(key, value);
            if(this.cache.size() >= this.capacity) {
                if (this.tail != null) {
                    this.cache.remove(this.tail.getKey());
                }
                removeTail();
            }
            addNodeToHead(node);
            this.cache.put(key, node);
        }
    }

    private void removeTail() {
        if (this.tail == this.head) {
            this.tail = null;
            this.head = null;
        } else {
            DoubleLinkedListNode pre = this.tail.getPre();
            pre.setNext(null);
            this.tail = pre;
        }
    }

    private void addNodeToHead(DoubleLinkedListNode node) {
        if (head == null) {
            this.head = node;
            this.tail = node;
        } else {
            node.setNext(this.head);
            node.setPre(null);
            this.head.setPre(node);
            this.head = node;
        }
    }

    private void moveNodeToHead(DoubleLinkedListNode node) {
        if (node != this.head) {
            DoubleLinkedListNode pre = node.getPre();
            DoubleLinkedListNode next = node.getNext();
            pre.setNext(next);
            if (next != null) {
                next.setPre(pre);
            } else {
                this.tail = pre;
            }
            addNodeToHead(node);
        }
    }
}
