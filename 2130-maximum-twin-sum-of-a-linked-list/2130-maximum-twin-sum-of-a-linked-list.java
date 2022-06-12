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
    public int pairSum(ListNode head) {
        ListNode slow=head, fast=head;
        while(fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        ListNode head2=slow.next, cur, tail=null;
        while(head2 !=null){
            cur=head2;
            head2=head2.next;
                
            cur.next=tail;
            tail=cur;
        }
        
        int ans=Integer.MIN_VALUE;
        while(tail!=null){
            ans=Math.max(ans, head.val+tail.val);
            head=head.next;
            tail=tail.next;
        }
        return ans;
    }
}