/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.*/

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
    public ListNode rotateRight(ListNode head, int n) {
        int listLen = 0; 
        ListNode node = head; 
        ListNode end = null; 
        while(node != null) {
            listLen++;
            if(node.next == null) {
                end = node; 
            }
            node = node.next;
        }
        if(listLen == 0) {
            return head; 
        }
        
        n = n % listLen; 
        if(n == 0) {
            return head;
        } 
        
        int count = listLen - n; 
        ListNode cutNode = head; 
        while(count > 1) {
            cutNode = cutNode.next; 
            count--;
        }
        
        ListNode newHead = cutNode.next; 
        end.next = head; 
        cutNode.next = null; 
        return newHead; 
    }
}