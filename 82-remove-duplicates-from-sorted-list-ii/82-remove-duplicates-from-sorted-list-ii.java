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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode(-1, head), cur=dummy;
        while(cur.next !=null && cur.next.next !=null){
            if(cur.next.val==cur.next.next.val){
                ListNode last=cur.next.next;
                while(last.next !=null && last.next.val==cur.next.val) last=last.next;
                cur.next=last.next;
            }else cur=cur.next;
        }
        return dummy.next;
    }
}