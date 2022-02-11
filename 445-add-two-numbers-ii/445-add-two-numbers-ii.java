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
        
        Stack<Integer> s1=new Stack<>();
        while(l1 !=null){
            s1.push(l1.val);
            l1=l1.next;
        }
        Stack<Integer> s2=new Stack<>();
        while(l2 !=null){
            s2.push(l2.val);
            l2=l2.next;
        }
        ListNode ans=new ListNode(0);
        while(!s1.isEmpty() || !s2.isEmpty() || ans.val !=0){
            int sum=ans.val+(s1.isEmpty()? 0:s1.pop())+(s2.isEmpty()? 0:s2.pop());
            ans.val=sum%10;
            
            ListNode newHead=new ListNode(sum/10);
            newHead.next=ans;
            ans=newHead;
        }
        return ans.next;
    }
}