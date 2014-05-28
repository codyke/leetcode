 /*Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3. */

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
        int value; 
        if (head == null) 
            return head;
        ListNode node1 = head;
        ListNode node2 = head.next;
        value = node1.val;
        while (node2 != null) {
            if (value != node2.val) {
                node1.next = node2;
                node1 = node2;
                node2 = node2.next;
                value = node1.val;
            } else {
                node2 = node2.next;
            }
        }
        node1.next = node2; 
        return head; 
    }
}