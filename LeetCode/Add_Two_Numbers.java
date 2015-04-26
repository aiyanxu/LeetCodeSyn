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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		int data = 0;
		int res = 0;
		ListNode pre = null,head=null,p=null;
		while(l1!=null && l2!=null){
			res += l1.val + l2.val;
			data = res % 10;
			res /=10;
			if(pre!=null){
				p = new ListNode(data);
				pre.next = p;
				pre = p;
			}else{
				pre=p=head=new ListNode(data);
			}
			l1 = l1.next;
			l2 = l2.next;
		}
		while(l1 != null){
			res += l1.val;
			data = res % 10;
			res /=10;
			p = new ListNode(data);
			pre.next = p;
			pre = p;
			l1 = l1.next;
		}
		while(l2 != null){
			res += l2.val;
			data = res % 10;
			res /=10;
			p = new ListNode(data);
			pre.next = p;
			pre = p;
			l2 =l2.next;
		}
		if(res > 0){
			p = new ListNode(1);
			pre.next = p;
			p.next = null;
		}
		return head;
	}
}