/*Given an array where elements are sorted in ascending order, convert it to a height balanced BST.*/
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
    public TreeNode sortedArrayToBST(int[] num) {
        int len = num.length; 
        if (len == 0) {
            return null;
        } else if(len == 1) {
            TreeNode node = new TreeNode(num[0]); 
            node.left = null;
            node.right = null;
            return node; 
        }
        
        int middle = len / 2; 
        TreeNode node = new TreeNode(num[middle]); 
        int[] left = Arrays.copyOfRange(num, 0, middle); 
        int[] right = Arrays.copyOfRange(num, middle + 1, len); 
        node.left = sortedArrayToBST(left); 
        node.right = sortedArrayToBST(right); 
        return node;
    }
}