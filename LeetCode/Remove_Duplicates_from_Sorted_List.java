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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
			return head;
		ListNode pre = head;
		ListNode p = head.next;
		
		while(p!=null){
			if(p.val == pre.val){
				pre.next = p.next;
				p = p.next;
			}else{
				pre = p;
				p = p.next;
			}
		}
		return head;
    }
}