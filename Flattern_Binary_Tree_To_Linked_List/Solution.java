/* Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6

The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6

click to show hints.
Hints:

If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
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
    public void flatten(TreeNode root) {
        if(root == null){
            return; 
        }
        if(root.left != null) {
            flatten(root.left); 
        } 
        if(root.right != null){
            flatten(root.right); 
        }
        if(root.left != null) {
            TreeNode tmp = root.right; 
            root.right = root.left; 
            root.left = null;
            TreeNode node = root.right; 
            while(node.right != null) {
                node = node.right; 
            }
            node.right = tmp; 
        }
    }
    
}