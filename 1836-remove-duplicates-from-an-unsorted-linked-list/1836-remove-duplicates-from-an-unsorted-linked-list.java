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
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        Map<Integer, Integer> map=new HashMap<>();
        ListNode dummy=new ListNode(-1, head), cur=head;
        
        while(cur !=null){
            map.put(cur.val, map.getOrDefault(cur.val, 0)+1);
            cur=cur.next;
        }
        cur=dummy;
        while(cur.next !=null){
            if(map.get(cur.next.val)>1){
                cur.next=cur.next.next;
            }else cur=cur.next;
        }
        return dummy.next;
    }
}