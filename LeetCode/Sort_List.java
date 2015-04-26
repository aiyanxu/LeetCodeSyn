/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head){
        return mergeSort(head);
    }
    private ListNode mergeSort(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode head1 = head;
        ListNode walker = head;
        ListNode runner = head;
        while (runner.next != null && runner.next.next != null){
            walker = walker.next;
            runner = runner.next.next;
        }
        ListNode head2 = walker.next;
        walker.next = null;
        head1 = mergeSort(head1);
        head2 = mergeSort(head2);
        return merge(head1,head2);
    }
    private ListNode merge(ListNode l1, ListNode l2){
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