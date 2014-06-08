/* Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.
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
    TreeNode pre = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true; 
        } else {
            return inOrderCheck(root); 
        }
    }
    
    public boolean inOrderCheck(TreeNode root) {
        boolean result; 
        if(root == null) {
            return true; 
        }
        result = inOrderCheck(root.left); 
        if(result == false) {
            return result; 
        } else if (pre != null) {
            if(pre.val >= root.val) {
                return false; 
            }
        }
        pre = root; 
        return inOrderCheck(root.right); 
    }
}