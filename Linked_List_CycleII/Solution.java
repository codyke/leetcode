/* Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Follow up:
Can you solve it without using extra space? */
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
    public ListNode detectCycle(ListNode head) {
         if (head != null && head.next != null) { 
            ListNode h1 = head;
            ListNode h2 = head;
            do {
                if (h1.next == null) 
                    return null;
                h1 = h1.next;
                if (h2.next == null || h2.next.next == null)
                    return null;
                h2 = h2.next.next;
            }while(h1 != h2);
            h1 = head;
            while(h1 != h2) {
                h1 = h1.next;
                h2 = h2.next;
            }
            return h1;
        } else {
            return null;
        }
        
    }
}
