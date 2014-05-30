/*Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7

return its bottom-up level order traversal as:

[
  [15,7],
  [9,20],
  [3]
]*/

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
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
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
                result.add(0, level); 
            }
        }
        
        return result;
    }
}
