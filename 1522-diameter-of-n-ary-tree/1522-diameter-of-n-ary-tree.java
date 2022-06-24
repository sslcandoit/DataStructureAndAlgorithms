/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    int max=0;
    public int diameter(Node root) {
        helper(root);
        return this.max;
    }
    public int helper(Node root) {
        if(root.children.size()==0) return 0;
        
        int m=root.children.size();
        int[] counts=new int[m];
        for(int i=0; i<m; i++) counts[i]=helper(root.children.get(i));
        Arrays.sort(counts);
        
        if(m==1) this.max=Math.max(this.max, counts[m-1]+1);
        else this.max=Math.max(this.max, counts[m-1]+counts[m-2]+2);
        
        return counts[m-1]+1;
    }
}