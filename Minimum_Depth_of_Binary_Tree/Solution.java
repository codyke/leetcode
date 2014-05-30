/*Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.*/

import java.lang.*;
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
    public int minDepth(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        return minHeight(root);
    }
    
    public int minHeight(TreeNode root) {
        if(root == null) {
            return 0; 
        }else if (root.left == null && root.right == null){
            return 1;
        }else {
            int left = minHeight(root.left); 
            int right = minHeight(root.right); 
            if(left == 0) {
                return right + 1;
            } else if(right == 0){
                return left + 1;
            } else {
                return Math.min(left, right) + 1; 
            }
        }
    }
}