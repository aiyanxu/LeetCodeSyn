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
    public ArrayList<Integer> postorderTraversal(TreeNode root){
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null;
        if (root == null){
            return result;
        }
        stack.push(root);
        while (!stack.empty()){
            TreeNode curr = stack.peek();
            if(prev == null || prev.left == curr || prev.right == curr){
                if (curr.left != null){
                    stack.push(curr.left);
                }else if (curr.right != null){
                    stack.push(curr.right);
                }else {
                    result.add(curr.val);
                    stack.pop();
                }
            } else if (curr.left == prev){
                if (curr.right != null){
                    stack.push(curr.right);
                } else{
                    result.add(curr.val);
                    stack.pop();
                }
            } else if (curr.right == prev){
                result.add(curr.val);
                stack.pop();
            }
            prev = curr;
        }
        return result;
    }
}