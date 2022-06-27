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
    public ListNode partition(ListNode head, int x) {
        if(head==null) return head;
        
        ListNode dummyS=new ListNode(-1),  small=dummyS;
        ListNode dummyL=new ListNode(-1),  large=dummyL;
        
        while(head !=null){
            ListNode temp=new ListNode(head.val);
            if(head.val<x){
                small.next=temp;
                small=small.next;
            }else{
                large.next=temp;
                large=large.next;
            } 
            head=head.next;
        }
        small.next=dummyL.next;
        return dummyS.next;
    }
}