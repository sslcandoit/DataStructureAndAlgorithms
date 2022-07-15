/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)-> a.val-b.val);
        
        for(ListNode l:lists){
            if(l !=null) pq.add(l);
        }
        
        ListNode dummy=new ListNode(-1), cur=dummy;
        
        while(!pq.isEmpty()){
            cur.next=pq.poll();
            cur=cur.next;
            
            if(cur.next !=null) pq.add(cur.next);
        }
        return dummy.next;
    }
}