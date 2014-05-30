/*You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8*/

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0; 
        ListNode result = new ListNode(0); 
        ListNode head = result; 
        ListNode left = null;
        while(l1 != null && l2 != null){
            ListNode node = new ListNode(0); 
            node.val = l1.val + l2.val + carry; 
            if(node.val >= 10) {
                node.val -= 10; 
                carry = 1; 
            } else {
                carry = 0; 
            }
            l1 = l1.next;
            l2 = l2.next; 
            if(result.next == null) {
                result.next = node; 
            }
            head.next = node; 
            head = head.next; 
        }
        if(l1 != null) {
            left = l1; 
        } else {
            left = l2; 
        }
        while(left != null) {
            ListNode node = new ListNode(0); 
            node.val = left.val + carry; 
            if(node.val >= 10) {
                node.val -= 10; 
                carry = 1; 
            } else {
                carry = 0; 
            }
            if(result.next == null) {
                result.next = node; 
            }
            head.next = node; 
            head = head.next; 
            left = left.next; 
        } 
        
        if(carry != 0) {
            ListNode node = new ListNode(carry); 
            head.next = node; 
            head = head.next; 
        }
        return result.next; 
    }
}