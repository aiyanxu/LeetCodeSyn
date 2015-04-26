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
   public void reorderList(ListNode head){
        if(head == null)
            return;
        ListNode p = head;
        ArrayList<ListNode> set = new ArrayList<ListNode>();
        while(p != null){
            set.add(p);
            p = p.next;
        }
        for (ListNode node : set)
            node.next = null;
        for(int i=0;i<set.size()-1-i;i++){
            set.get(i).next = set.get(set.size()-1-i);
            if (i+1 != set.size()-1-i)
                set.get(set.size()-1-i).next = set.get(i+1);
        }
    }
}