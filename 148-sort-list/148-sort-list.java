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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        
        ListNode mid=findMid(head);
        ListNode head2=mid.next;
        mid.next=null;
        
        return merge(sortList(head), sortList(head2));
    }
    private ListNode findMid(ListNode head){
        ListNode slow=head, fast=head;
        while(fast.next != null && fast.next.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    private ListNode merge(ListNode head, ListNode head2){
        ListNode dummy=new ListNode(-1), cur=dummy;
        while(head !=null && head2 !=null){
            if(head.val<head2.val){
                cur.next=head;
                head=head.next;
            }else{
                cur.next=head2;
                head2=head2.next;
            }
            cur=cur.next;
        }
        if(head==null) cur.next=head2;
        else cur.next=head;
        return dummy.next;
    }
}