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
        
        this.l=head;
        return check(head);
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