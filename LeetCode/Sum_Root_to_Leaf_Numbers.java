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
    public int sumNumbers(TreeNode root) {
        if(root == null)
			return 0;
		return helper(root,root.val);
    }
    
    private int helper(TreeNode root,int v){
		if(root.left == null && root.right == null)
			return v;
		if(root.right == null){
			return helper(root.left,v*10+root.left.val);
		}
		else if(root.left == null){
			return helper(root.right,v*10+root.right.val);
		}
		else{
			return helper(root.right,v*10+root.right.val) + helper(root.left,v*10+root.left.val);
		}
	}
}