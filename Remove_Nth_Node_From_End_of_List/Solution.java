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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        for(int i = 0; i < n; i++) {
            fast = fast.next;
        }

        ListNode pre = null;
        while(fast != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next;
        }
        if (pre == null) {
            head = slow.next;
        } else {
            pre.next = slow.next;
        }

        return head;
    }
}
