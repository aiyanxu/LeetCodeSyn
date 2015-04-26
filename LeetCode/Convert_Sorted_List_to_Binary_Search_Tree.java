/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
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
     public TreeNode sortedListToBST(ListNode head){
        if(head == null)
            return null;
        return helper(head);
    }

    private TreeNode helper(ListNode head){
        if (head == null)
            return null;
        if (head.next == null)
            return new TreeNode(head.val);
        ListNode walker = head;
        ListNode runner = head;
        ListNode pre = head;
        while(runner.next != null && runner.next.next != null){
            pre = walker;
            walker = walker.next;
            runner = runner.next.next;
        }
        ListNode head2 = walker.next;
        pre.next = null;
        TreeNode root = new TreeNode(walker.val);
        if(pre == walker)
            root.left = null;
        else
            root.left = helper(head);
        root.right = helper(head2);
        return root;
    }
}