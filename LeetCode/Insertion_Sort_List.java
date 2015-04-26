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
    public ListNode insertionSortList(ListNode head){
        if(head == null)
            return head;
        ListNode newHead = new ListNode(head.val);
        ListNode ppre = head;
        ListNode p = head.next;
        while(p != null){
            ppre.next = p.next;
            if(p.val <= newHead.val){
                p.next = newHead;
                newHead = p;
            }
            else{
                ListNode q = newHead.next;
                ListNode pre =newHead;
                while(q != null && !(pre.val <= p.val && p.val <= q.val)){
                    pre = q;
                    q = q.next;
                }
                pre.next = p;
                p.next = q;
            }
            p = ppre.next;
        }
        return newHead;
    }
}