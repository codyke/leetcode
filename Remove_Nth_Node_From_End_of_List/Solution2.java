/*Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:
Given n will always be valid.
Try to do this in one pass. */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head; 
        while(p2 != null) {
            if (n >= 0) {
                p2 = p2.next; 
                n--; 
            } else {
                p1 = p1.next;
                p2 = p2.next; 
            }
        }
        // p1 point to the previous node we need to delete 
        ListNode p3 = (p1.next == null) ? null : p1.next.next;
        if(n >= 0) {
            head = head.next;
        } else {
            p1.next = p3; 
        }
        
        return head;
    }
}