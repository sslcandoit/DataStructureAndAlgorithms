/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    private Node pre;
    public Node treeToDoublyList(Node root) {
        if(root==null) return root;
        
        Node dummy=new Node(-1);
        this.pre=dummy;
        
        helper(root);
        pre.right=dummy.right;
        dummy.right.left=pre;
        return dummy.right;
    }
    private void helper(Node cur){
        if(cur==null) return;
        helper(cur.left);
        
        pre.right=cur;
        cur.left=pre;
        pre=cur;
        
        helper(cur.right);
    }
    
}