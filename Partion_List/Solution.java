/*Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5. */

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
    public ListNode partition(ListNode head, int x) {
        ListNode p1 = head; 
        ListNode llp = null; 
        ListNode gfp = null;
        ListNode cur = head; 
        ListNode pre = null;
        ListNode result = head; 
        // find the first node that is not smaller than x 
        while(cur != null && cur.val < x) {
            pre = cur; 
            cur = cur.next; 
        }
        llp = pre; 
        gfp = cur; 
        
        while(cur != null) {
            if(cur.val >= x) {
                pre = cur; 
                cur = cur.next; 
                continue; 
            } else {
                if(llp == null) {
                    llp = cur; 
                    pre.next = cur.next; 
                    llp.next = gfp; 
                    result = llp; 
                    cur = pre.next; 
                } else {
                    llp.next = cur; 
                    pre.next = cur.next; 
                    llp = llp.next; 
                    llp.next = gfp; 
                    cur = pre.next; 
                }
            }
        }
        return result; 
    }
}