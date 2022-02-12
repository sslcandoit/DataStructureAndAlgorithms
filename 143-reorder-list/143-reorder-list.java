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
    public void reorderList(ListNode head) {
        if(head.next==null) return;
        
        ListNode start=findMid(head);
        ListNode newStart=reverse(start);
        averageMerge(head, newStart);
    }
    private void averageMerge(ListNode first, ListNode second){
        while(second.next !=null){
            ListNode temp=first.next;
            first.next=second;
            first=temp;
            
            temp=second.next;
            second.next=first;
            second=temp;
        }
    }
    private ListNode reverse(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode pre=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode nxt=cur.next;
            cur.next=pre;
            pre=cur;
            cur=nxt;
        }
        return pre;
    }
    private ListNode findMid(ListNode head){
        ListNode slow=head, fast=head;
        while(fast !=null && fast.next !=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}