/*Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        int i = 1; 
        List<TreeNode> result = new ArrayList<TreeNode>(); 
        for(i = 1; i <= n; i++) {
            List<TreeNode> leftTree = generateTree(1, i - 1); 
            List<TreeNode> rightTree = generateTree(i + 1, n); 
            int leftNum = leftTree.size(); 
            int rightNum = rightTree.size(); 
            if(leftNum == 0 && rightNum == 0) {
                TreeNode root = new TreeNode(i);
                root.left = null; 
                root.right = null; 
                result.add(root);
            } else if(leftNum == 0) {
                for(int k = 0; k < rightNum; k++) {
                    TreeNode root = new TreeNode(i);
                    root.left = null; 
                    root.right = rightTree.get(k); 
                    result.add(root); 
                }
            } else if (rightNum == 0) {
                for(int j = 0; j < leftNum; j++) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree.get(j); 
                    root.right = null; 
                    result.add(root); 
                }
            } else {
                for(int j = 0; j < leftNum; j++) {
                    for(int k = 0; k < rightNum; k++) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftTree.get(j); 
                        root.right = rightTree.get(k); 
                        result.add(root); 
                    }
                }
            }
        }
        if(n == 0){
            TreeNode root = null;
            result.add(root);
        }
        return result; 
    }
    
    public List<TreeNode> generateTree(int start, int end) {
        int i = start; 
        List<TreeNode> result = new ArrayList<TreeNode>(); 
        for(; i <= end; i++) {
            List<TreeNode> leftTree = generateTree(start, i - 1); 
            List<TreeNode> rightTree = generateTree(i + 1, end); 
            int leftNum = leftTree.size(); 
            int rightNum = rightTree.size(); 
            if(leftNum == 0 && rightNum == 0) {
                TreeNode root = new TreeNode(i);
                root.left = null; 
                root.right = null; 
                result.add(root); 
            } else if(leftNum == 0) {
                for(int k = 0; k < rightNum; k++) {
                    TreeNode root = new TreeNode(i);
                    root.left = null; 
                    root.right = rightTree.get(k); 
                    result.add(root); 
                }
            } else if (rightNum == 0) {
                for(int j = 0; j < leftNum; j++) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree.get(j); 
                    root.right = null; 
                    result.add(root); 
                }
            } else {
                for(int j = 0; j < leftNum; j++) {
                    for(int k = 0; k < rightNum; k++) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftTree.get(j); 
                        root.right = rightTree.get(k); 
                        result.add(root); 
                    }
                }
            }
        }
        return result;
    }
}