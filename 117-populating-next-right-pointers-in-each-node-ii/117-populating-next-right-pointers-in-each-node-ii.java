/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        Node cur=root, rowHead=null, rowPre=null;
        
        while(cur!=null){
            while(cur!=null){
                if(cur.left !=null){
                    if(rowHead==null){
                        rowHead=cur.left;
                        rowPre=cur.left;
                    }else{
                        rowPre.next=cur.left;
                        rowPre=rowPre.next;
                    }
                }
                if(cur.right !=null){
                    if(rowHead==null){
                        rowHead=cur.right;
                        rowPre=cur.right;
                    }else{
                        rowPre.next=cur.right;
                        rowPre=rowPre.next;
                    }
                }
                cur=cur.next;
            }
            cur=rowHead;
            rowHead=null;
            rowPre=null;
        }
        return root;
    }
}