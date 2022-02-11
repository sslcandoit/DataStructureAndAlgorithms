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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        
        ListNode dummy=new ListNode(-1);
        ListNode head=dummy;
        int sum=0;
        while(l1 !=null || l2 !=null || sum >0){
            sum+=(l1==null? 0:l1.val)+(l2==null? 0:l2.val);
            head.next=new ListNode(sum%10);
            head=head.next;
            
            if(l1 !=null) l1=l1.next;
            if(l2 !=null) l2=l2.next;
            sum=sum/10;
        }
        return dummy.next;
    }
}