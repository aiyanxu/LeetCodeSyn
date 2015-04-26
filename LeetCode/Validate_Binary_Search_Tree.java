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
    public boolean isValidBST(TreeNode root){
        if(root == null)
            return true;
        ArrayList<Integer> res = new ArrayList<Integer>();
        helper(root,res);
        for(int i=0;i<res.size()-1;i++){
            if(res.get(i) >= res.get(i+1))
                return false;
        }
        return true;
    }

    private void helper(TreeNode root,ArrayList<Integer> res){
        if(root.left != null)
            helper(root.left,res);
        res.add(root.val);
        if(root.right != null)
            helper(root.right,res);
    }
}