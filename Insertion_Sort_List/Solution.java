/*Sort a linked list using insertion sort.*/

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
    public ListNode insertionSortList(ListNode head) {
        ListNode header = new ListNode(0); 
        header.next = head; 
        ListNode min = header.next; 
        ListNode max = header.next;
    
        ListNode p = header.next; 
        if(p == null || p.next == null) {
            return head; 
        } else {
            p = p.next; 
        }
        while(p != null) {
            if(p.val <= min.val) {
                ListNode tmp = p.next; 
                p.next = min; 
                min = p; 
                header.next = min; 
                max.next = tmp; 
                p = tmp;
            } else if (p.val >= max.val) {
                max = p; 
                p = p.next; 
            } else {
                ListNode t1 = min; 
                ListNode t2 = min.next; 
                while(t1 != null && t2 != null){
                    if(t2.val >= p.val) {
                        break; 
                    } else {
                        t1 = t2; 
                        t2 = t2.next; 
                    }
                }
                ListNode tmp = p.next; 
                p.next = t2; 
                t1.next = p;
                max.next = tmp; 
                p = tmp; 
            }
        }
        return header.next;
    }
}