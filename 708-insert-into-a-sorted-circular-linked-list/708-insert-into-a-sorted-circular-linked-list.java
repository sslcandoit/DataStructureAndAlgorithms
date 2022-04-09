/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        if(head==null){
            Node newNode =new Node(insertVal);
            newNode.next=newNode;
            return newNode;
        } 
        Node max=head;
        while(max.next !=head && max.val<=max.next.val) max=max.next;
        
        Node min=max.next;
        if(insertVal>=max.val || insertVal<=min.val) {
            Node node=new Node(insertVal, min);
            max.next=node;
        }else{
            while(min.next.val<insertVal) min=min.next;
            Node node=new Node(insertVal, min.next);
            min.next=node;
        }
        return head;
    }
}