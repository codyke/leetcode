/* Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed. */

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
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode headNode = new ListNode(0);
        headNode.next = head;
        ListNode p1 = headNode;
        ListNode p2 = head;
        ListNode p3 = head.next;
        ListNode tmp = null;
        while(p2 != null && p3 !=null) {
            //swap
            p1.next = p3;
            tmp = p3.next;
            p3.next = p2;
            p2.next = tmp;
            
            //move to next pair
            p1 = p2;
            p2 = p2.next;
            if(p2 != null) 
                p3 = p2.next;
        }
        
        if (headNode.next != null)
            return headNode.next;
        else 
            return head;
    }
}