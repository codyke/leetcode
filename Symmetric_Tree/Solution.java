/*Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3

But the following is not:

    1
   / \
  2   2
   \   \
   3    3
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
    public boolean isSymmetric(TreeNode root){
        // iteratively 
        ArrayList<TreeNode> leftStack = new ArrayList<TreeNode>(); 
        ArrayList<TreeNode> rightStack = new ArrayList<TreeNode>(); 
        if(root == null) {
            return true; 
        } else if(root.left == null && root.right == null){
            return true; 
        } else if(root.left == null || root.right == null) {
            return false; 
        } else {
            leftStack.add(root.left); 
            rightStack.add(root.right); 
        }
        
        while(leftStack.size() != 0 && rightStack.size() != 0) {
            int leftSize = leftStack.size() - 1; 
            int rightSize = rightStack.size() - 1; 
            
            TreeNode left = leftStack.get(leftSize); 
            TreeNode right = rightStack.get(rightSize); 
            if(left.val != right.val){
                return false; 
            }
            
            if(left.left == null && left.right == null 
                && right.left == null && right.right ==null) {
                leftStack.remove(leftSize); 
                rightStack.remove(rightSize); 
                continue;
            } 
            
            if(left.left != null && right.right !=null) {
                leftStack.add(left.left); 
                left.left = null;
                rightStack.add(right.right); 
                right.right = null;
            } else if(left.left == null && right.right == null) {
                if(left.right != null && right.left !=null) {
                    leftStack.add(left.right);
                    left.right = null;
                    rightStack.add(right.left);
                    right.left = null;
                } else {
                    return false; 
                }
            } else {
                return false; 
            }
        }
        return true; 
    }
    /*public boolean isSymmetric(TreeNode root) {
        // recursively 
        if(root == null) {
            return true; 
        } else if(root.left == null && root.right == null){
            return true; 
        } else if(root.left == null || root.right == null) {
            return false; 
        } else {
            return isSameTree(root.left, root.right);
        }
    }
    
    public boolean isSameTree(TreeNode left, TreeNode right){
        if(left == null && right == null) {
            return true; 
        } else if(left == null || right == null) {
            return false; 
        } else if(left.val != right.val) {
            return false; 
        } else {
            return isSameTree(left.left, right.right) && isSameTree(left.right, right.left);
        }
    }
    */
}