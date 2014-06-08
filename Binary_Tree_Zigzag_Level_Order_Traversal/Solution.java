/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7

return its zigzag level order traversal as:

[
  [3],
  [20,9],
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>(); 
        List<TreeNode> curLevel = new ArrayList<TreeNode>(); 
        List<TreeNode> nextLevel = new ArrayList<TreeNode>(); 
        boolean reverse = false; 
        if(root == null) {
            return result; 
        }
        curLevel.add(root); 
        List<Integer> subResult = new ArrayList<Integer>(); 
        while(!curLevel.isEmpty()) {
            TreeNode n = curLevel.get(0); 
            subResult.add(n.val); 
            if(n.left != null) {
                nextLevel.add(n.left); 
            }
            if(n.right != null) {
                nextLevel.add(n.right); 
            }
            curLevel.remove(0); 
            if(curLevel.isEmpty()) {
                if(reverse) {
                    Collections.reverse(subResult); 
                    result.add(subResult); 
                } else {
                    result.add(subResult); 
                }
                reverse = !reverse; 
                subResult = new ArrayList<Integer>(); 
                if(nextLevel.isEmpty()) {
                    break;
                } else {
                    List<TreeNode> tmp = curLevel; 
                    curLevel = nextLevel; 
                    nextLevel = tmp; 
                }
            }
        }
        return result;
    }
}