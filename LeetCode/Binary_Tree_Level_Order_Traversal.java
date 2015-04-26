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
   public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return res;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int curNum = 0;
        int lastNum = 1;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(!queue.isEmpty()){
            TreeNode tmp = queue.poll();
            lastNum--;
            list.add(tmp.val);
            if(tmp.left != null){
                queue.add(tmp.left);
                curNum++;
            }
            if(tmp.right != null){
                queue.add(tmp.right);
                curNum++;
            }
            if(lastNum == 0){
                lastNum = curNum;
                curNum = 0;
                res.add(list);
                list = new ArrayList<Integer>();
            }
        }
        return res;
    }
}