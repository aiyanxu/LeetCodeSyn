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
    public void flatten(TreeNode root){
        if(root == null)
            return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode tmp = stack.pop();
            res.add(tmp);
            if(tmp.right != null)
                stack.push(tmp.right);
            if(tmp.left != null)
                stack.push(tmp.left);
        }
        for(int i=0;i<res.size()-1;i++){
            res.get(i).left = null;
            res.get(i).right = res.get(i+1);
        }
        res.get(res.size()-1).right = null;
        res.get(res.size()-1).left = null;
    }
}