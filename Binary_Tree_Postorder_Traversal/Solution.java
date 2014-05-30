/*Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3

return [3,2,1]. */

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
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>(); 
        postorderTraversal(root, result);
        return result; 
    }
    public void postorderTraversal(TreeNode root, ArrayList<Integer> result) {
        if(root != null) {
            if(root.left != null) {
                postorderTraversal(root.left, result); 
            } 
            if(root.right != null) {
                postorderTraversal(root.right, result); 
            }
            result.add(root.val); 
        }
    }
}