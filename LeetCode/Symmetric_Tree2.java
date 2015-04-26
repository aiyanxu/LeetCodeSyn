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
    public boolean isSymmetric(TreeNode root) {
         if(root == null)
            return true;
        return symmetric(root.left,root.right);
    }
    
    private boolean symmetric(TreeNode left,TreeNode right){
        if(left == null)
            return right == null;
        if(right == null)
            return left == null;
        if(left.val != right.val)
            return false;
        if(!symmetric(left.right,right.left))
            return false;
        if(!symmetric(left.left,right.right))
            return false;
        return true;
    }
}