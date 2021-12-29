package com.company;

import java.util.*;

/**
 Given the head of a linked list, return the list after sorting it in ascending order.

 Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?



 Example 1:


 Input: head = [4,2,1,3]
 Output: [1,2,3,4]
 Example 2:


 Input: head = [-1,5,3,4,0]
 Output: [-1,0,3,4,5]
 Example 3:

 Input: head = []
 Output: []
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null) {
            return null;
        }

        return bottomUpMergeSort(head);
    }

    private ListNode bottomUpMergeSort(ListNode head) {
        int batchSize = 2;
        ListNode batchHead;
        ListNode newHead = null;
        ListNode nextTmpHead = head;
        ListNode preBatchHead = null;
        int iter = 0;
        while(true) {
            while(nextTmpHead != null) {
                batchHead = nextTmpHead;
                ListNode tmp = batchHead;
                for (int i = 1; i < batchSize && tmp.next != null; i++) {
                    tmp = tmp.next;
                }
                nextTmpHead = tmp.next;
                tmp.next = null;
                ListNode sortedNodes = doOneBatch(batchHead, batchSize);
                if (newHead == null) {
                    newHead = sortedNodes;
                }
                if (preBatchHead != null) {
                    while (preBatchHead.next != null) {
                        preBatchHead = preBatchHead.next;
                    }
                    preBatchHead.next = sortedNodes;
                }
                preBatchHead = sortedNodes;
                iter++;
            }
            if(iter <= 1) {
                break;
            }
            iter = 0;
            batchSize *= 2;
            nextTmpHead = newHead;
            newHead = null;
            preBatchHead = null;
        }

        return newHead;
    }

    private ListNode doOneBatch(ListNode head, int batchSize) {
        ListNode firstHalf = head;
        ListNode secondHalf = head;
        ListNode firstHalfEnd = head;
        ListNode secondHalfEnd = head;
        ListNode newHead;
        ListNode p;
        // init start point
        for(int i = 1; i <= batchSize / 2 && secondHalf != null; i++) {
            firstHalfEnd = secondHalf;
            secondHalf = secondHalf.next;
        }
        if (secondHalf == null) {
            // if there is no secondHalf, we are done
            return head;
        }
        secondHalfEnd = secondHalf;
        for(int i = 1; i <= batchSize / 2 && secondHalfEnd.next != null; i++) {
            secondHalfEnd = secondHalfEnd.next;
        }

        firstHalfEnd.next = null;
        secondHalfEnd.next = null;
        newHead = combineTwoList(firstHalf, secondHalf);

        return newHead;
    }

    private ListNode combineTwoList(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode newHead = null;
        ListNode p = null;
        while(p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                if (newHead == null) {
                    newHead = p1;
                    p = p1;
                } else {
                    p.next = p1;
                    p = p.next;
                }
                p1 = p1.next;
            } else {
                if (newHead == null) {
                    newHead = p2;
                    p = p2;
                } else {
                    p.next = p2;
                    p = p.next;
                }
                p2 = p2.next;
            }
        }

        if(p1 != null) {
            p.next = p1;
        }
        if(p2 != null) {
            p.next = p2;
        }

        return newHead;
    }

    private ListNode mergeSort(ListNode head) {
        ListNode p = head;
        ListNode pFast = head;
        while(pFast.next != null && pFast.next.next != null) {
            pFast = pFast.next.next;
            p = p.next;
        }
        if (head == p && p.next == null) {
            return head;
        }

        ListNode leftHead = head;
        ListNode rightHead = p.next;
        p.next = null;

        leftHead = mergeSort(leftHead);
        rightHead = mergeSort(rightHead);

        return combineTwoList(leftHead, rightHead);
    }


}