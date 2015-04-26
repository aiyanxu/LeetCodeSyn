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
    public ArrayList<Integer> preorderTraversal(TreeNode root){
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null)
            return res;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode tmp = stack.pop();
            res.add(tmp.val);
            if(tmp.right != null)
                stack.push(tmp.right);
            if(tmp.left != null)
                stack.push(tmp.left);
        }
        return res;
    }
}