/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head,int x){
        ListNode firsthead = new ListNode(0);
        ListNode secondhead = new ListNode(0);
        ListNode p = firsthead;
        ListNode q = secondhead;
        ListNode r = head;
        while(r!=null){
            if(r.val < x){
                p.next = r;
                p = r;
            }
            else{
                q.next = r;
                q = r;
            }
            r = r.next;
        }
        q.next = null;
        p.next = secondhead.next;
        return firsthead.next;
    }
}