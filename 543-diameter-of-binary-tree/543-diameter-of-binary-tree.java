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
    private int max;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null ||(root.left==null && root.right==null)) return 0;
        
        this.max=0;
        maxDepth(root);
        return this.max;
    }
    private int maxDepth(TreeNode root){
        if(root==null) return 0;

        int l=0, r=0;
        if(root.left!=null) l=maxDepth(root.left)+1;
        if(root.right !=null) r=maxDepth(root.right)+1;
        
        this.max=Math.max(this.max, l+r);
        return Math.max(l, r);
    }
}