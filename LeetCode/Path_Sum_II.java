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
     public ArrayList<ArrayList<Integer>> pathSum(TreeNode root,int sum){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> l = new ArrayList<Integer>();
        pathSumHelper(root, sum, res,l);
        return res;
    }

    private void pathSumHelper(TreeNode root, int sum, ArrayList<ArrayList<Integer>> res,ArrayList<Integer> l){
        if(root == null)
            return;
        if(root.val == sum && root.left == null && root.right == null){
            l.add(root.val);
            ArrayList<Integer> tmp = new ArrayList<Integer>(l);
            res.add(tmp);
            l.remove(l.size()-1);
            return;
        }
        l.add(root.val);
        pathSumHelper(root.left,sum-root.val,res,l);
        pathSumHelper(root.right,sum-root.val,res,l);
        l.remove(l.size()-1);
    }
}