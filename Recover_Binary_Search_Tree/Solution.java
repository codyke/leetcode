/* Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.
Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution? */

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
    // recursively 
        TreeNode pre = null; 
        TreeNode first = null; 
        TreeNode second = null; 
    public void recoverTree(TreeNode root) {
        pre = null; 
        first = null; 
        second = null; 
        InOrderTraveral(root); 
        if(first != null) {
            if(second == null) {
                second = pre; 
            }
            int tmp; 
            tmp = first.val; 
            first.val = second.val; 
            second.val = tmp;
        }
    }
    
    /*public void InOrderTraveral(TreeNode root) {
        if(root == null) {
            return; 
        }
        InOrderTraveral(root.left); 
        if(pre != null) {
            if(first == null && pre.val > root.val) {
                first = pre; 
            } else if(first != null && root.val > first.val) {
                second = pre; 
            }
            
            if(first != null && second != null) {
                return; 
            }
        }
        pre = root; 
        InOrderTraveral(root.right); 
    }*/
    
    public void InOrderTraveral(TreeNode root) {
        TreeNode cur = root; 
        TreeNode p = null; 
        while(cur != null) {
            if(cur.left == null) {
                judge(cur); 
                pre = cur; 
                cur = cur.right; 
            } else {
                // find the right most chid of left tree
                p = cur.left; 
                while(p != null) {
                    if(p.right == null) {
                        p.right = cur;
                        cur = cur.left; 
                        break; 
                    } else if(p.right == cur) {
                        p.right = null; 
                        judge(p); 
                        pre = p; 
                        judge(cur); 
                        pre = cur; 
                        cur = cur.right; 
                        break; 
                    } else {
                        p = p.right; 
                    }
                }
            }
        }
    }
    
    public void judge(TreeNode p) {
        if(pre != null && p != null) {
            if(first == null && pre.val > p.val) {
                first = pre; 
            } else if (first != null && first.val < p.val) {
                if(second == null)
                    second = pre; 
            }
        }
    }
}