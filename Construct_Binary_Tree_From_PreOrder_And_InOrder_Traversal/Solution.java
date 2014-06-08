/*Given preorder and inorder traversal of a tree, construct the binary tree.*/

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preNum = preorder.length; 
        int inNum = inorder.length; 
        TreeNode root = null;
        
        if(preNum == 0) {
            return root; 
        } else {
            root = new TreeNode(preorder[0]); 
            // find the root.val in inorder array 
            int i; 
            for(i = 0; i < inNum; i++) {
                if(inorder[i] == root.val) {
                    break; 
                }
            }
            // left inorder array 
            int[] leftInOrder = Arrays.copyOfRange(inorder, 0, i); 
            // left postorder array 
            int[] leftPreOrder = Arrays.copyOfRange(preorder, 1, i + 1); 
            root.left = buildTree(leftPreOrder, leftInOrder); 
            
            if(i == inNum) {
                root.right = null;
            } else {
                // right inorder array
                int[] rightInOrder = Arrays.copyOfRange(inorder, i + 1, inNum); 
                // right postorder array
                int[] rightPreOrder = Arrays.copyOfRange(preorder, i + 1, preNum); 
                root.right = buildTree(rightPreOrder, rightInOrder); 
            }
        }
        
        return root; 
    }
}