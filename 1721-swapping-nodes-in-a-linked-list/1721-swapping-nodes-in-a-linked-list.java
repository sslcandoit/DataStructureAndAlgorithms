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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummy=new ListNode(-1, head), slow=dummy, fast=dummy;
        ListNode left, right;
        
        for(int i=1; i<=k; i++) fast=fast.next;
        left=fast;
        
        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        right=slow;
        
        int temp=left.val;
        left.val=right.val;
        right.val=temp;
        return dummy.next;
    }
}