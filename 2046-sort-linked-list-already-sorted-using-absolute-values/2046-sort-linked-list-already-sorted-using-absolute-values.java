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
    public ListNode sortLinkedList(ListNode head) {
        ListNode neg=null, dummy=new ListNode(-1, head), cur=dummy;
        
        while(cur.next !=null){
            if(cur.next.val<0){
                ListNode temp=new ListNode(cur.next.val, neg);
                neg=temp;
                
                cur.next=cur.next.next;
            }else cur=cur.next;
        }
        if(neg==null) return head;
        
        cur=neg;
        while(cur !=null && cur.next !=null) cur=cur.next;
        
        cur.next=dummy.next;
        return neg;
    }
}