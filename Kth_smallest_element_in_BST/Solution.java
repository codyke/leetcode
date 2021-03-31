package com.company;

/*
Given the root of a binary search tree, and an integer k, return the kth (1-indexed) smallest element in the tree.
*/

import java.util.Stack;

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        int[] result = new int[k];
        int idx = 0;

        // in-order visit the tree
        if (root == null) {
            return 0;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left == null) {
                result[idx++] = node.val;
            } else {
                stack.push(new TreeNode(node.val));
                stack.push(node.left);
            }

            if (idx >= k) {
                break;
            }
        }
        return result[k - 1];
    }
}