/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    boolean findP;
    boolean findQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || p==null || q==null) return null;
        this.findP=false;
        this.findQ=false;
        TreeNode ans=lca(root, p, q);
        return (findP&&findQ)? ans:null;
    }
    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
        if(root==null) return null;
      
        TreeNode l=lca(root.left, p, q);
        TreeNode r=lca(root.right, p, q);
        
        if(root==p){
            findP=true;
            return root;
        }
        if(root==q){
            findQ=true;
            return root;
        }
        if(l !=null && r !=null) return root;
        return l==null? r:l;
    }
}