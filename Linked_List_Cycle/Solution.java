/*Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head != null && head.next != null) { 
            ListNode h1 = head;
            ListNode h2 = head;
            do {
                if (h1.next == null) 
                    return false;
                h1 = h1.next;
                if (h2.next == null || h2.next.next == null)
                    return false;
                h2 = h2.next.next;
            }while(h1 != h2);
            return true;
        } else {
            return false;
        }
        
    }
}