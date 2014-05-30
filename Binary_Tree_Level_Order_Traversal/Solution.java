/*Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7

return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]
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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(); 
        Queue<TreeNode> s1 = new ArrayDeque<TreeNode>(); 
        Queue<TreeNode> s2 = new ArrayDeque<TreeNode>(); 
        Queue<TreeNode> cur = s1;
        Queue<TreeNode> next = s2; 
        Queue<TreeNode> tmp = null;
        if(root == null) {
            return result; 
        }
        next.add(root);
        while (next.peek() != null) {
            tmp = cur; 
            cur = next; 
            next = tmp; 
            ArrayList<Integer> level = new ArrayList<Integer>(); 
            while(cur.peek() != null) {
                TreeNode node = cur.poll(); 
                if(node == null) {
                    continue; 
                }
                level.add(node.val); 
                if(node.left != null) {
                    next.add(node.left); 
                }
                if(node.right != null) {
                    next.add(node.right); 
                }
            }
            if(level.size() > 0) {
                result.add(level); 
            }
        }
        
        return result;
    }
}