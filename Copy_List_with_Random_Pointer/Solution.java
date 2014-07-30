/* A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list. */

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode p = head; 
        if(head == null) {
            return null; 
        }
        
        // insert new node
        while(p != null) {
            RandomListNode n = new RandomListNode(p.label); 
            n.next = p.next; 
            n.random = p.random; 
            p.next = n; 
            p = n.next; 
        }
        
        // reconstruct the random pointer
        p = head; 
        while(p != null) {
            RandomListNode n = p.next; 
            if(n.random != null) {
                n.random = n.random.next; 
            }
            p = n.next; 
        }
        
        // decouple two list 
        p = head; 
        RandomListNode result = p.next;
        RandomListNode p1 = p.next; 
        while(p != null && p1 != null) {
            p.next = p1.next; 
            if(p1.next != null) {
                p1.next = p1.next.next; 
            }
            p = p.next; 
            p1 = p1.next; 
        }
        return result; 
    }
}