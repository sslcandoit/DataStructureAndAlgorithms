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
    private ListNode l;
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        ListNode mid=findMid(head);
        ListNode head_r=reverse(mid.next);
        while(head_r !=null){
            if(head_r.val !=head.val) return false;
            head_r=head_r.next;
            head=head.next;
        }
        return true;
        /*
        this.l=head;
        return check(head);
        */
    }
    private ListNode reverse(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode n=reverse(head.next);
        head.next.next=head;
        head.next=null;
        return n;
    }
    private ListNode findMid(ListNode head){
        ListNode fast=head, slow=head;
        while(fast.next !=null && fast.next.next !=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public boolean check(ListNode head){
        if(head !=null){
            if(!check(head.next)) return false;
            if(head.val !=this.l.val) return false;
            l=l.next;
        }
        return true;
    }
    
}