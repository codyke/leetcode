package com.company;

/*
Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.



Example 1:


Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]
Example 2:


Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]
*/


import java.util.*;

class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = null;
        ListNode evenHead = null;
        ListNode oddTail = null;
        ListNode evenTail = null;

        ListNode p = head;
        boolean isOdd = true;
        while(p != null) {
            if(isOdd) {
                if (oddHead == null) {
                    oddHead = p;
                    oddTail = p;
                } else {
                    oddTail.next = p;
                    oddTail = oddTail.next;
                }
            } else {
                if (evenHead == null) {
                    evenHead = p;
                    evenTail = p;
                } else {
                    evenTail.next = p;
                    evenTail = evenTail.next;
                }
            }
            p = p.next;
            isOdd = !isOdd;
        }
        if (evenTail != null) {
            evenTail.next = null;
        }
        if (oddTail != null) {
            oddTail.next = evenHead;
        }
        return oddHead;
    }

    public static void main(String[] str) {

    }
}