package com.company;

import java.util.*;

/**
 * Design and implement a data structure for a Least Frequently Used (LFU) cache.
 *
 * Implement the LFUCache class:
 *
 * LFUCache(int capacity) Initializes the object with the capacity of the data structure.
 * int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
 * void put(int key, int value) Update the value of the key if present, or inserts the key if not already present. When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item. For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.
 * To determine the least frequently used key, a use counter is maintained for each key in the cache. The key with the smallest use counter is the least frequently used key.
 *
 * When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation). The use counter for a key in the cache is incremented either a get or put operation is called on it.
 *
 *
 *
 * Example 1:
 *
 * Input
 * ["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, 3, null, -1, 3, 4]
 *
 * Explanation
 * // cnt(x) = the use counter for key x
 * // cache=[] will show the last used order for tiebreakers (leftmost element is  most recent)
 * LFUCache lfu = new LFUCache(2);
 * lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
 * lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
 * lfu.get(1);      // return 1
 *                  // cache=[1,2], cnt(2)=1, cnt(1)=2
 * lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
 *                  // cache=[3,1], cnt(3)=1, cnt(1)=2
 * lfu.get(2);      // return -1 (not found)
 * lfu.get(3);      // return 3
 *                  // cache=[3,1], cnt(3)=2, cnt(1)=2
 * lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
 *                  // cache=[4,3], cnt(4)=1, cnt(3)=2
 * lfu.get(1);      // return -1 (not found)
 * lfu.get(3);      // return 3
 *                  // cache=[3,4], cnt(4)=1, cnt(3)=3
 * lfu.get(4);      // return 4
 *                  // cache=[3,4], cnt(4)=2, cnt(3)=3
 */
class LFUCache {
    class DoubleLinkedListNode {
        private DoubleLinkedListNode pre;
        private DoubleLinkedListNode next;
        private int key;
        private int value;
        private int count;

        public DoubleLinkedListNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.count = 1;
        }

        public DoubleLinkedListNode(int count) {
            this.count = count;
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

        public int getCount() { return this.count; }

        public void incrCount() { this.count++; }
    }

    private Map<Integer, DoubleLinkedListNode> cacheMap = new HashMap<>();

    private Map<Integer, DoubleLinkedListNode> freqMap = new HashMap<>();

    private int curCapacity;

    private int maxCapacity;

    private int curLeastCount = Integer.MAX_VALUE;

    public LFUCache(int capacity) {
        this.maxCapacity = capacity;
    }

    public int get(int key) {
        DoubleLinkedListNode node = cacheMap.get(key);
        if (node == null) {
            return -1;
        } else {
            updateFrequency(node);
            return node.getValue();
        }
    }

    public void put(int key, int value) {
        if (maxCapacity == 0) {
            return;
        }
        DoubleLinkedListNode node = cacheMap.get(key);
        if (node != null) {
            node.setValue(value);
            updateFrequency(node);
        } else {
            node = new DoubleLinkedListNode(key, value);
            if (curCapacity == maxCapacity) {
                deleteLFU();
                curCapacity--;
            }
            DoubleLinkedListNode root = freqMap.get(node.getCount());
            this.curLeastCount = node.getCount();
            if (root == null) {
                root = new DoubleLinkedListNode(node.getCount());
                freqMap.put(node.getCount(), root);
            }
            this.insertToNewRoot(root, node);
            cacheMap.put(key, node);
            curCapacity++;
        }
    }

    private void deleteLFU() {
        DoubleLinkedListNode root = freqMap.get(this.curLeastCount);
        removeTail(root);
        if(root.getNext() == null) {
            freqMap.remove(root.getCount());
        }
    }

    private void removeTail(DoubleLinkedListNode root) {
        DoubleLinkedListNode node = root;
        while(node.getNext() != null) {
            node = node.getNext();
        }
        DoubleLinkedListNode pre = node.getPre();
        pre.setNext(null);
        cacheMap.remove(node.getKey());
    }

    private void updateFrequency(DoubleLinkedListNode node) {
        DoubleLinkedListNode curRoot = freqMap.get(node.getCount());
        node.incrCount();
        DoubleLinkedListNode newRoot = freqMap.get(node.getCount());
        if (newRoot == null) {
            newRoot = new DoubleLinkedListNode(node.getCount());
        }
        this.removeItself(node);
        this.insertToNewRoot(newRoot, node);
        freqMap.put(newRoot.getCount(), newRoot);
        // check whether curRoot is empty
        if (curRoot.getNext() == null) {
            freqMap.remove(curRoot.getCount());
            if (this.curLeastCount == curRoot.getCount()) {
                this.curLeastCount = newRoot.getCount();
            }
        }
    }

    private void insertToNewRoot(DoubleLinkedListNode root, DoubleLinkedListNode node) {
        DoubleLinkedListNode next = root.getNext();
        root.setNext(node);
        node.setPre(root);
        node.setNext(next);
        if (next != null) {
            next.setPre(node);
        }
    }

    private void removeItself(DoubleLinkedListNode node) {
        DoubleLinkedListNode pre = node.getPre();
        DoubleLinkedListNode next = node.getNext();
        pre.setNext(next);
        if (next != null) {
            next.setPre(pre);
        }
        node.setNext(null);
        node.setPre(null);
    }
}