/* Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3

Return 6. */

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
    int MaxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) {
            return 0; 
        }
        int left = maxSubTreeSum(root.left); 
        int right = maxSubTreeSum(root.right); 
        if((left + root.val + right) > MaxSum) {
            MaxSum = left + root.val + right; 
        } else if((left + root.val) > MaxSum) {
            MaxSum = left + root.val; 
        } else if((right + root.val) > MaxSum) {
            MaxSum = right + root.val; 
        }
        
        return MaxSum; 
    }
    
    public int maxSubTreeSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int left = maxSubTreeSum(root.left); 
        int right = maxSubTreeSum(root.right); 
        if((left + root.val + right) > MaxSum) {
            MaxSum = left + root.val + right; 
        } else if((left + root.val) > MaxSum) {
            MaxSum = left + root.val; 
        } else if((right + root.val) > MaxSum) {
            MaxSum = right + root.val; 
        }
        
        int result = ((left > right) ? left : right) + root.val; 
        return (result > 0) ? result : 0; 
    }
    
}