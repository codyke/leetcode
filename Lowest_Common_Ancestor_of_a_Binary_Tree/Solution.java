package com.company;

import java.util.*;

/**
 Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

 According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”



 Example 1:


 Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 Output: 3
 Explanation: The LCA of nodes 5 and 1 is 3.
 Example 2:


 Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 Output: 5
 Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 Example 3:

 Input: root = [1,2], p = 1, q = 2
 Output: 1
 */
class Solution {
    TreeNode result = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return result;
    }

    private boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        if(result != null) {
            return false;
        }
        boolean cur = false;
        boolean left = false;
        boolean right = false;
        if (node.val == p.val || node.val == q.val) {
            cur = true;
        }

        if (node.left != null) {
            left = dfs(node.left, p, q);
            if (cur && left) {
                result = node;
                return left | cur | right;
            }
        }

        if (node.right != null) {
            right = dfs(node.right, p, q);
            if (cur && right) {
                result = node;
                return left | cur | right;
            }
        }

        if (left && right) {
            result = node;
        }
        return left | cur | right;
    }
}