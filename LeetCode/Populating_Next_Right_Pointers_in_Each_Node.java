/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public  void connect(TreeLinkNode root){
        if(root == null)
            return;
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.add(root);
        int currentLayer = 1;
        int nextLayer = 0;
        while(!queue.isEmpty()){
            TreeLinkNode tmp = queue.poll();
            currentLayer -= 1;
            if(tmp.left != null){
                queue.add(tmp.left);
                nextLayer += 1;
            }
            if(tmp.right != null){
                queue.add(tmp.right);
                nextLayer += 1;
            }
            if(currentLayer == 0){
                tmp.next = null;
                currentLayer = nextLayer;
                nextLayer = 0;
            }else{
                tmp.next = queue.peek();
            }
        }
    }
}