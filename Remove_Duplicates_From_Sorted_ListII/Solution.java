/* Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3. */

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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p1 = null;
        ListNode p2 = null;
        ListNode p = null;
        ListNode result = null;
        int flag = 0;
        if (head == null || head.next == null) {
            return head;
        }
        p1 = head;
        p2 = head.next; 
        while(p2 != null && p1 != null) {
            if (p1.val != p2.val) {
                if(p == null && result == null && flag == 0) {
                    // record first node
                    p = p1;
                    result = p; 
                } else if (flag == 0){
                    p.next = p1; 
                    p = p.next;
                }
                p1 = p2; 
                p2 = p2.next;
                flag = 0;
            } else {
                p2 = p2.next; 
                flag = 1; 
            }
        }
        if (flag == 0 && p1 != null) {
            if (p == null && result == null) {
                p = p1; 
                result = p;
            } else {
                p.next = p1;
                p = p.next;
            }
        }
        if (p != null) {
            p.next = null;
        }
        return result; 
    }
}