/*Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.*/

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode lp1 = l1;
        ListNode lp2 = l2;
        ListNode lp3 = new ListNode(0);
        ListNode result = lp3;
        
        while (lp1 != null && lp2 != null) {
            if (lp1.val < lp2.val) {
                lp3.next = lp1;
                lp1 = lp1.next;
            } else {
                lp3.next = lp2;
                lp2 = lp2.next;
            }
            lp3 = lp3.next;
        }
        
        if (lp1 == null) {
            lp3.next = lp2; 
        } 
        
        if (lp2 == null) {
            lp3.next = lp1; 
        }
        
        return result.next;
    }
}