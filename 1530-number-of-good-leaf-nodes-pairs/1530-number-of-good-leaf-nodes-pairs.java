/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int ans=0, distance;
    public int countPairs(TreeNode root, int distance) {
        this.distance=distance;
        helper(root);
        return this.ans;
    }
    private int[] helper(TreeNode root){
        if(root==null) return new int[this.distance+1];
        if(root.left==null && root.right==null){
            int[] temp=new int[this.distance+1];
            temp[1]=1;
            return temp;
        } 
        int[] l=helper(root.left);
        int[] r=helper(root.right);
        
        for(int i=1; i<=this.distance; i++){
            if(l[i]<1) continue;
            for(int j=1; j<=this.distance; j++){
                if(r[j]<1) continue;
                if(i+j<=this.distance) this.ans+=l[i]*r[j];
            }
        }
        int[] a=new int[this.distance+1];
        for(int i=1; i<this.distance; i++){
            a[i+1]=l[i]+r[i];
        }
        return a;
    }
}