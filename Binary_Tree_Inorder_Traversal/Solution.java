/*Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3

return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?

confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.*/
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
    /*public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>(); 
        inorderTraversal(root, result);
        return result; 
    }
    
    public void inorderTraversal(TreeNode root, ArrayList<Integer> result) {
        if(root != null) {

            if(root.left != null) {
                inorderTraversal(root.left, result);
            } 
            result.add(root.val); 
            if(root.right != null) {
                inorderTraversal(root.right, result);
            }
        }
    }*/
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>(); 
        ArrayList<TreeNode> stack = new ArrayList<TreeNode>(); 
        TreeNode cur = root; 
        int size = -1; 
        while(!stack.isEmpty() || cur != null) {
            if(cur != null) {
                // go left 
                stack.add(cur); 
                ++size; 
                cur = cur.left; 
            } else {
                cur = stack.remove(size); 
                --size; 
                result.add(cur.val); 
                cur = cur.right;
            }
        }
        return result; 
    }
}
		