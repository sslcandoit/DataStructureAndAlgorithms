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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null ||head.next==null) return head;
        
        ListNode dummy=new ListNode(-1, head);
        ListNode pre=dummy;
        for(int i=1; i<left; i++) pre=pre.next;
        
        ListNode cur=pre.next;
        for(int i=left; i<right; i++){
            ListNode next=cur.next;
            cur.next=next.next;
            next.next=pre.next;
            pre.next=next;
        }
        return dummy.next;
    }
}