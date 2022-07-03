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
    public Node inorderSuccessor(Node node) {
        if(node.right !=null){
            Node ans=node.right;
            while(ans.left !=null) ans=ans.left;
            return ans;
        }
        Node ans=node.parent;
        while(ans !=null && ans.val<node.val) ans=ans.parent;
        return ans;
    }
}