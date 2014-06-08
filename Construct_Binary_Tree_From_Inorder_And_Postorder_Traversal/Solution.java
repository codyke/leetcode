/*Given inorder and postorder traversal of a tree, construct the binary tree.*/

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int postNum = postorder.length; 
        int inNum = inorder.length; 
        TreeNode root = null;
        
        if(postNum == 0) {
            return root; 
        } else {
            root = new TreeNode(postorder[postNum - 1]); 
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
            int[] leftPostOrder = Arrays.copyOfRange(postorder, 0, i); 
            root.left = buildTree(leftInOrder, leftPostOrder); 
            
            if(i == inNum) {
                root.right = null;
            } else {
                // right inorder array
                int[] rightInOrder = Arrays.copyOfRange(inorder, i + 1, inNum); 
                // right postorder array
                int[] rightPostOrder = Arrays.copyOfRange(postorder, i, postNum - 1); 
                root.right = buildTree(rightInOrder, rightPostOrder); 
            }
        }
        
        return root; 
    }
}