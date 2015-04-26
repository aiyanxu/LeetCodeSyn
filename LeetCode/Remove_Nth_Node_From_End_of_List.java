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
    public ListNode removeNthFromEnd(ListNode head, int n){
		ListNode p = head;
		ListNode q = head;
		ListNode pre = null;
		
		if(head == null){
			return null;
		}
		
		for(int i=1;i<=n-1;i++){
			q =q.next;
		}
		while(q.next != null){
			pre = p;
			p = p.next;
			q = q.next;
		}
		if(pre == null ){
			head = p.next;
		}else{
			pre.next = p.next;
		}
		return head;
	}
    
}