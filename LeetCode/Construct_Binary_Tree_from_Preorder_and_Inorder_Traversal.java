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
    public TreeNode buildTree(int[] preorder,int[] inorder){
        return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    private TreeNode helper(int[] preorder,int pstart, int pend, int[] inorder, int istart, int iend){
        if(pstart > pend || istart > iend){
            return null;
        }
        TreeNode root = new TreeNode(preorder[pstart]);
        int idx = findRootIndex(preorder,pstart,inorder,istart,iend);
        root.left = helper(preorder,pstart+1,pstart+idx-istart,inorder,istart,idx-1);
        root.right = helper(preorder,idx-iend+pend+1,pend,inorder,idx+1,iend);
        return root;
    }
    private int findRootIndex(int[] preorder,int pstart,int[] inorder,int istart,int iend){
        for(int i=istart;i<=iend;i++){
            if(inorder[i] == preorder[pstart])
                return i;
        }
        return -1;
    }
}