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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        
        int n=0;
        ListNode cur=head;
        while(cur !=null){
            n++;
            cur=cur.next;
        }
        k=k%n;
        if(k==0) return head;
        
        ListNode slow=head, fast=head;
        while(k>0){
            fast=fast.next;
            k--;
        }
        while(fast.next !=null){
            slow=slow.next;
            fast=fast.next;
        }
        ListNode list2=slow.next;
        slow.next=null;
        fast.next=head;
        return list2;
    }
}