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
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int curNum = 0;
        int lastNum = 1;
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        while(!queue.isEmpty()){
            TreeNode tmp = queue.poll();
            lastNum--;
            list.add(tmp);
            if(tmp != null) {
                queue.add(tmp.left);
                curNum++;
                queue.add(tmp.right);
                curNum++;
            }
            if(lastNum == 0){
                int start = 0, end = list.size()-1;
                while(start < end){
                    TreeNode p = list.get(start);
                    TreeNode q = list.get(end);
                    int l = p==null? -1 : p.val;
                    int r = q==null? -1 : q.val;
                    if(l != r)
                        return false;
                    start++;
                    end--;
                }
                lastNum = curNum;
                curNum = 0;
                list = new ArrayList<TreeNode>();
            }
        }
        return true;
    }
}