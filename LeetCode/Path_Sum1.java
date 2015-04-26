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
    boolean find = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if(root.val == sum && root.left == null && root.right == null){
			find = true;
		}
		if(root.left != null){
			hasPathSum(root.left,sum-root.val);
		}
		if(root.right != null){
			hasPathSum(root.right,sum-root.val);
		}
		return find;
    }
}