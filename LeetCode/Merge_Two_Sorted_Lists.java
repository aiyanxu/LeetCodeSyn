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
   public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode p = l1,q = l2;
        ListNode fakeHead = new ListNode(0);
        ListNode f = fakeHead;
        while(p != null && q != null){
            if(p.val <= q.val ){
                f.next = p;
                p = p.next;
            }else{
                f.next = q;
                q = q.next;
            }
            f = f.next;
        }
        if(p != null)
            f.next = p;
        if(q != null)
            f.next = q;
        return fakeHead.next;
    }
}