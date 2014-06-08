/*Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        int length = listLength(head); 
        TreeNode parent = constructBST(head, 0, length - 1); 
        return parent; 
    }
    
    public TreeNode constructBST(ListNode head, int start, int end) {
        ListNode node = getMidNode(head, start, end);
        int midNum = (end - start) / 2 + start;
        if(node != null) {
            TreeNode root = new TreeNode(node.val); 
            if(midNum - 1 >= start) {
                root.left = constructBST(head, start, midNum - 1); 
            } 
            if(midNum + 1 <= end) {
                root.right = constructBST(node.next, midNum + 1, end); 
            }
            return root;
        } else {
            return null;
        }
    }
    
    public int listLength(ListNode head) {
        int nodeLength = 0; 
        ListNode n = head; 
        while(n != null) {
            nodeLength++; 
            n = n.next; 
        }
        return nodeLength; 
    }
    
    public ListNode getMidNode(ListNode head, int start, int end) {
        if(end < start) 
            return null; 
        int midNum = (end - start) / 2; 
        ListNode p = head; 
        while(midNum > 0) {
            p = p.next; 
            midNum--; 
        }
        
        return p; 
    }
}