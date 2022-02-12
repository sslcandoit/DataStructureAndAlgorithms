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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode dummy=new ListNode(-1, head);
        ListNode pre=dummy;
        while(head !=null && head.next !=null){
            ListNode first=head;
            ListNode second=head.next;
            
            pre.next=second;
            first.next=second.next;
            second.next=first;
            
            pre=first;
            head=first.next;
        }
        return dummy.next;
        /*
        if(head==null || head.next==null) return head;
        
        ListNode first=head;
        ListNode second=head.next;
        
        first.next=swapPairs(second.next);
        second.next=first;
        return second;
        */
    }
}