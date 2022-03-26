/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        int n=grid.length;
        return helper(grid, 0, 0, n);
    }
    private Node helper(int[][] grid, int rowS, int colS, int size){
        if(size==1) return new Node(grid[rowS][colS]==1, true, null, null, null, null);
        
        Node head=new Node();
        Node topLeft=helper(grid, rowS, colS, size/2);
        Node topRight=helper(grid, rowS, colS+size/2, size/2);
        Node bottomLeft=helper(grid, rowS+size/2, colS, size/2);
        Node bottomRight=helper(grid, rowS+size/2, colS+size/2, size/2);
        
        if(topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf 
           && topLeft.val==topRight.val && topRight.val==bottomLeft.val && bottomLeft.val==bottomRight.val){
            head.val=topLeft.val;
            head.isLeaf=true;
        }else{
            head.topLeft=topLeft;
            head.topRight=topRight;
            head.bottomLeft=bottomLeft;
            head.bottomRight=bottomRight;
        }
        return head;
    }
}