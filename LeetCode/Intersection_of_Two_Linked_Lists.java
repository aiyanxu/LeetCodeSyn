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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
		ListNode q = headB;
		if(headA == null || headB == null)
			return null;
		int m =0,n = 0;
		while(headA != null){
			m += 1;
			headA = headA.next;
		}
		while(headB != null){
			n += 1;
			headB = headB.next;
		}
		int i = Math.abs(m-n);
		if(m>=n){
			while(i>0){
				p = p.next;
				i--;
			}
		}else{
			while(i>0){
				q = q.next;
				i--;
			}
		}
		while(p != null && q != null){
			if(p == q)
				return p;
			p = p.next;
			q = q.next;
		}
		return null;
        
    }
}