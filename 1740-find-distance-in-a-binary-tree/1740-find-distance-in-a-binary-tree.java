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
    public int findDistance(TreeNode root, int p, int q) {
        TreeNode lca=lca(root, p, q);
        return distance(lca, p, 0)+distance(lca, q, 0);
    }
    private TreeNode lca(TreeNode root, int p, int q){
        if(root==null) return null;

        TreeNode l=lca(root.left, p, q);
        TreeNode r=lca(root.right, p, q);
        if(root.val==p || root.val==q || (l!=null && r !=null)) return root;
        return l==null? r:l;
    }
    private int distance(TreeNode root, int target, int dis){
        if(root==null) return -1;
        
        if(root.val==target) return dis;
        
        int left= distance(root.left, target, dis+1);
        if(left ==-1){
            return distance(root.right, target, dis+1);
        }
        return left;
    }
}