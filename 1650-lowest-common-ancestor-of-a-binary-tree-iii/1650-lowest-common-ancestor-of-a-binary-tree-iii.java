/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node n1=p;
        Node n2=q;
        while(n1 !=n2){
            n1=n1.parent;
            n2=n2.parent;
            if(n1==null) n1=q;
            if(n2==null) n2=p;
        }
        return n1;
    }
    
    /*
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> set=new HashSet<>();
        while(p!=null){
            set.add(p);
            p=p.parent;
        }
        while(!set.contains(q)) q=q.parent;
        return q;
    }      */
}