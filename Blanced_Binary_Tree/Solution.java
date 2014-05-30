/*Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. */

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
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int[] h = new int[1];
        return treeHeight(root, h); 
    }
    
    public boolean treeHeight(TreeNode node, int[] height) {
        if(node == null){
            height[0] = 0;
            return true;
        }
        if(node.left == null && node.right == null) {
            height[0] = 1;
            return true; 
        } else {
            boolean balance = false; 
            int[] leftH = new int[1];
            int[] rightH = new int[1];
            if (treeHeight(node.left, leftH) && treeHeight(node.right, rightH)
                && (Math.abs(leftH[0] - rightH[0]) <= 1)){
                balance = true; 
            }
            height[0] = Math.max(leftH[0], rightH[0]) + 1; 
            return balance; 
        }
    }
}