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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode header = new ListNode(0);
        header.next = head; 
        ListNode start = header; 
        ListNode end = null; 
        ListNode first = null; 
        ListNode last = null; 
        ListNode cur = header; 
        int i = 0; 
        while(true){
            first = cur; 
            for(i = 0; i < k; i++) {
                cur = cur.next; 
                if(cur == null) {
                    break; 
                }
            }
            last = cur; 
            if(last == null) {
                break; 
            }
            end = last.next; 
            start.next = reverseKNode(first.next, last, k); 
            cur = start; 
            for(i = 0; i < k; i++) {
                cur = cur.next; 
            }
            cur.next = end; 
            start = cur;
        }
        return header.next;
    }
    
    public ListNode reverseKNode(ListNode first, ListNode last, int k) {
        ListNode newLast = first; 
        if(k == 1) {
            return first;
        } else if(k == 2) {
            last.next = first; 
            first.next = null; 
        } else {
            int i = 0; 
            for(i = 1; i < k - 1; i++) {
                newLast = newLast.next; 
            }
            last.next = reverseKNode(first, newLast, k - 1);
        }
        return last; 
    }
}