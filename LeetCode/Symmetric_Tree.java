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
        int curNum = 1;
        while(curNum > 0){
            int i=0;
            while(i<curNum){
                TreeNode tmp = queue.get(i);
                i++;
                if(tmp == null)
                    continue;
                queue.add(tmp.left);
                queue.add(tmp.right);
            }
            int start = 0,end = curNum - 1;
            while(start< end){
                TreeNode p = queue.get(start);
                TreeNode q = queue.get(end);
                int l = p==null? -1 : p.val;
                int r = q==null? -1 : q.val;
                if(l != r)
                    return false;
                start++;
                end--;
            }
            queue.subList(0,curNum).clear();
            curNum = queue.size();
        }
        return true;
    }
}