package com.company;

import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
   /* public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            if (root.left != null) {
                result.addAll(inorderTraversal(root.left));
            }
            result.add(root.val);
            if (root.right != null) {
                result.addAll(inorderTraversal(root.right));
            }
        }
        return  result;
    }*/

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node != null) {
                if (node.left == null) {
                    result.add(node.val);
                } else {
                    TreeNode inNode = new TreeNode(node.val, null, null);
                    stack.push(inNode);
                    stack.push(node.left);
                }
            }
        }
        return result;
    }
}