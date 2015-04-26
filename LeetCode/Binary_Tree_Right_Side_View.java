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
    public ArrayList<Integer> rightSideView(TreeNode root){
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int current = 1;
        int next = 0;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            current--;
            if (node.left != null){
                queue.add(node.left);
                next++;
            }
            if (node.right != null){
                queue.add(node.right);
                next++;
            }
            if (current == 0){
                res.add(node.val);
                current = next;
                next = 0;
            }
        }
        return res;
    }
}