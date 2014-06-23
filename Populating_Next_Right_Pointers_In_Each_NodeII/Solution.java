/*Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

    You may only use constant extra space.

For example,
Given the following binary tree,

         1
       /  \
      2    3
     / \    \
    4   5    7

After calling your function, the tree should look like:

         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
*/

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode result = root; 
        TreeLinkNode next = root; 
        TreeLinkNode cur = null;
        TreeLinkNode child = null; 
        while(next != null) {
            cur = next; 
            next = null; 
            while(cur != null) {
                if(cur.left != null) {
                    child = cur.left; 
                    next = cur.left; 
                    break;
                } else if(cur.right != null){
                    child = cur.right; 
                    next = cur.right; 
                    break;
                } else {
                    cur = cur.next; 
                }
            }
            while(cur != null && child != null) {
               if(cur.left != null) {
                   if(cur.left != child) {
                       child.next = cur.left; 
                       child = child.next;
                   } else {
                      if(cur.right != null) {
                          child.next = cur.right;
                          child = child.next;
                      }
                      cur = cur.next; 
                   }
                   
               } else if (cur.right != null) {
                   if(cur.right != child) {
                       child.next = cur.right; 
                       child = child.next;
                       cur = cur.next;
                   } else {
                       cur = cur.next; 
                   }
               } else {
                   cur = cur.next; 
               }
            }
        }        
    }
}