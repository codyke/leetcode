/*Given two integer arrays preorder and inorder where preorder is the preorder traversal of a
binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
Example 1:


Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]
*/

import com.company.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<Integer, Integer> inorderIdx = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++) {
            inorderIdx.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, 0, inorder.length);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int rootInPreorder, int inorderStart, int inorderEnd) {
        if (rootInPreorder >= preorder.length || inorderStart >= inorderEnd) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[rootInPreorder]);
        int leftEnd = inorderStart - 1;
        int rightStart = inorderEnd;
        int idx = inorderIdx.get(preorder[rootInPreorder]);
        leftEnd =  idx;
        rightStart = idx + 1;

        if (leftEnd != inorderStart - 1) {
            node.left = buildTree(preorder, inorder, rootInPreorder + 1, inorderStart, leftEnd);
        }

        if (rightStart != inorderEnd) {
            int rightInPreorder = rootInPreorder + rightStart - inorderStart;
            node.right = buildTree(preorder, inorder, rightInPreorder, rightStart, inorderEnd);
        }

        return node;
    }

    public TreeNode buildTree_inefficient(int[] preorder, int[] inorder ) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[0]);
        int leftEnd = -1;
        int rightStart = inorder.length;
        int idx = 0;
        while(idx < inorder.length) {
            if(inorder[idx] == preorder[0]) {
                leftEnd = idx;
                rightStart = idx + 1;
                break;
            }
            idx++;
        }

        if (leftEnd != -1) {
            node.left = buildTree(Arrays.copyOfRange(preorder, 1, preorder.length),
                    Arrays.copyOfRange(inorder, 0, leftEnd));
        }

        if (rightStart != inorder.length) {
            node.right = buildTree(Arrays.copyOfRange(preorder, leftEnd + 1, preorder.length),
                    Arrays.copyOfRange(inorder, rightStart, inorder.length));
        }

        return node;
    }

    public static void main(String[] args) {
        com.company.Solution s = new com.company.Solution();
        TreeNode root = s.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        System.out.println(root);
    }
}