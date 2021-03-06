/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return null;
        while (head != null && head.val == val){
            head = head.next;
        }
        if(head == null)
            return null;
        ListNode pre = head,p = head;
        while(p != null){
            if(p.val == val){
                pre.next = p.next;
            }
            else{
                pre = p;
            }
            p = p.next;
        }
        return head;
    }
}