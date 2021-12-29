package com.company;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        boolean leftToRight = true;
        if(root != null) {
            deque.add(root);
        }
        while(!deque.isEmpty()) {
            // let's deal with level by level
            List<Integer> levelResult = new ArrayList<>();
            int num = deque.size();
            for(int i = 0; i < num; i++) {
                TreeNode node = deque.pop();
                if (leftToRight) {
                    levelResult.add(node.val);
                } else {
                    levelResult.add(0, node.val);
                }
                if(node.left != null) {
                    deque.add(node.left);
                }
                if(node.right != null) {
                    deque.add(node.right);
                }
            }
            result.add(levelResult);
            leftToRight = !leftToRight;
        }
        return result;
    }
}