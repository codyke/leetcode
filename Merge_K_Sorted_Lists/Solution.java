/*Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity. */

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
 
 // O(kN) k is the list number and N is the total elements
 // if we use heap to get the minum elemtn of each list, we can 
 // reach O(N*log(k))
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        int listNum = lists.size(); 
        ListNode result = null;
        ListNode p = null;
        
        // no list, return null
        if (listNum == 0) {
            return result;
        }
        
        ListNode minNode = null;
        while((minNode = getminNodeAndAdvance(lists)) != null) { 
            if (p == null) {
                p = minNode; 
                result = p; 
            } else {
                p.next = minNode; 
                p = p.next; 
            }
        }
        
        return result;
    }
    
    public ListNode getminNodeAndAdvance(ArrayList<ListNode> lists) {
        int i = 0; 
        int num = lists.size(); 
        int minIndex = -1; 
        ListNode min = null; 
        ListNode tmp = null;
        for(i = 0; i < num; i++) {
            tmp = lists.get(i); 
            if (tmp == null) {
                continue; 
            } else if (min == null || min.val > tmp.val) {
                min = tmp;
                minIndex = i; 
            }
        }
        if (min != null && minIndex >= 0) {
            tmp = lists.remove(minIndex); 
            tmp = tmp.next; 
            lists.add(tmp); 
        }
        return min; 
    }
}