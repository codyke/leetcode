/*Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3

return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?*/

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
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>(); 
        ArrayList<TreeNode> stack = new ArrayList<TreeNode>(); 
        int size = -1; 
        stack.add(root); 
        ++size; 
        while(!stack.isEmpty()) {
            TreeNode node = stack.remove(size); 
            size--;
            if(node != null) {
                result.add(node.val); 
                if(node.right != null) {
                    stack.add(node.right); 
                    size++; 
                } 
                if(node.left != null) {
                   stack.add(node.left); 
                   size++; 
                }
            }
        }
        return result; 
    }
    /*public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>(); 
        preorderTraversal(root, result);
        return result; 
    }
    
    public void preorderTraversal(TreeNode root, ArrayList<Integer> result) {
        if(root != null) {
            result.add(root.val); 
            if(root.left != null) {
                preorderTraversal(root.left, result);
            } 
            if(root.right != null) {
                preorderTraversal(root.right, result);
            }
        }
    }*/
}