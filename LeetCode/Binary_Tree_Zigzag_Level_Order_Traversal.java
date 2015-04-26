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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return res;
        ArrayList<Integer> item = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        boolean direction = true;
        int currentlayernumber = 1;
        int nextlayernumber = 0;
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            currentlayernumber -= 1;
            item.add(tmp.val);
            if (tmp.left != null) {
                queue.add(tmp.left);
                nextlayernumber += 1;
            }
            if (tmp.right != null) {
                queue.add(tmp.right);
                nextlayernumber += 1;

            }
            if (currentlayernumber == 0) {
                if(direction)
                    res.add(new ArrayList<Integer>(item));
                else{
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    for(int i=item.size()-1;i>=0;i--)
                        temp.add(item.get(i));
                    res.add(temp);
                }
                item.clear();
                direction = !direction;
                currentlayernumber = nextlayernumber;
                nextlayernumber = 0;
            }
        }
        if(item != null && item.size() != 0){
            if(direction)
                res.add(new ArrayList<Integer>(item));
            else{
                ArrayList<Integer> temp = new ArrayList<Integer>();
                for(int i=item.size()-1;i>=0;i--)
                    temp.add(item.get(i));
                res.add(temp);
            }
        }
        return res;
    }
}