/* Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ¡Ü m ¡Ü n ¡Ü length of list. */


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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode header = new ListNode(0); 
        header.next = head; 
        ListNode p1 = header; 
        ListNode p2 = p1.next; 
        int i = 1;
        for(i = 1; i <= m - 1; i++) {
            p1 = p1.next;
            p2 = p2.next;
        }
        if(p2 == null || p2.next == null) {
            return header.next; 
        }
        for(i = m; i < n; i++) {
            ListNode tmp = p1.next; 
            p1.next = p2.next;
            p2.next = p2.next.next; 
            p1.next.next = tmp; 
        }
        
        return header.next; 
    }
}