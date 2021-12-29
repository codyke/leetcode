package com.company;

import java.util.*;

/**
 Given the head of a linked list, remove the nth node from the end of the list and return its head.

 Follow up: Could you do this in one pass?



 Example 1:


 Input: head = [1,2,3,4,5], n = 2
 Output: [1,2,3,5]
 Example 2:

 Input: head = [1], n = 1
 Output: []
 Example 3:

 Input: head = [1,2], n = 1
 Output: [1]
 */


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(0);
        ListNode p1 = l1;
        ListNode p2 = l2;
        int carry = 0;
        ListNode cur = sum;
        while (p1 != null && p2 != null) {
            int twoSum = p1.val + p2.val + carry;
            carry = twoSum / 10;

            ListNode n = new ListNode(twoSum % 10);
            cur.next = n;
            cur = n;
            p1 = p1.next;
            p2= p2.next;
        }

        ListNode r = p1 == null ? p2 : p1;
        while(r != null) {
            int twoSum = r.val + carry;
            carry = twoSum / 10;
            ListNode n = new ListNode(twoSum % 10);
            cur.next = n;
            cur = n;
            r = r.next;
        }

        if(carry > 0) {
            ListNode n = new ListNode(carry);
            cur.next = n;
        }

        return  sum.next;
    }
}