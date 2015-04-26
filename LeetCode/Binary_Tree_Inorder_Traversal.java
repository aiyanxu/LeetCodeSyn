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
   public ArrayList<Integer> inorderTraversal(TreeNode root){
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null){
            if(p != null) {
                stack.push(p);
                p = p.left;
            }else{
                TreeNode tmp = stack.pop();
                res.add(tmp.val);
                p = tmp.right;
            }
        }
        return res;
    }
}