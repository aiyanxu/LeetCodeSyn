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
    public TreeNode buildTree(int[] inorder, int[] postorder){
        return helper(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }

    private TreeNode helper(int[] inorder,int istart,int iend,int[] postorder,int pstart,int pend){
        if(istart > iend || pstart > pend)
            return null;
        TreeNode root = new TreeNode(postorder[pend]);
        int idx = findRootIndex(postorder,pend,inorder,istart,iend);
        root.left = helper(inorder,istart,idx-1,postorder,pstart,pstart+idx-istart-1);
        root.right = helper(inorder,idx+1,iend,postorder,pend-iend+idx,pend-1);
        return root;
    }
    private int findRootIndex(int[] postorder,int pend,int[] inorder,int istart,int iend){
        for(int i=istart;i<=iend;i++){
            if(inorder[i] == postorder[pend])
                return i;
        }
        return -1;
    }
}