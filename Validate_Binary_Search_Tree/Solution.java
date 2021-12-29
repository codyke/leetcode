package com.company;

import java.util.*;

/**
 Given the root of a binary tree, determine if it is a valid binary search tree (BST).

 A valid BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.


 Example 1:


 Input: root = [2,1,3]
 Output: true
 Example 2:


 Input: root = [5,1,4,null,null,3,6]
 Output: false
 Explanation: The root node's value is 5 but its right child's value is 4.
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBinarySearchTree(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBinarySearchTree(TreeNode node, long min, long max) {
        if(node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return isValidBinarySearchTree(node.left, min, node.val) && isValidBinarySearchTree(node.right, node.val, max);
    }

    public boolean isValidBinarySearchTree(TreeNode node) {
        boolean result = true;
        if(node.left != null) {
            result &= isValidBinarySearchTree(node.left);
            if(getMaxFromTree(node.left) >= node.val) {
                result &= false;
            }
        }
        if(result && node.right != null) {
            result &= isValidBinarySearchTree(node.right);
            if(getMinFromTree(node.right) <= node.val) {
                result &= false;
            }
        }

        return result;
    }


    public int getMaxFromTree(TreeNode node) {
        TreeNode tmp = node;
        int result;
        do {
            result = tmp.val;
            tmp = tmp.right;
        } while(tmp != null);

        return result;
    }

    public int getMinFromTree(TreeNode node) {
        TreeNode tmp = node;
        int result;
        do {
            result = tmp.val;
            tmp = tmp.left;
        } while(tmp != null);

        return result;
    }
}