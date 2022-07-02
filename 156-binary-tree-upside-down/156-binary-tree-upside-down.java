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
    TreeNode newRoot=null;
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        helper(root);
        return this.newRoot;
    }
    private TreeNode helper(TreeNode root){
        if(root==null) return null;
        
        TreeNode l=helper(root.left);
        TreeNode r=helper(root.right);
        
        if(l==null && r==null){
            if(this.newRoot==null) this.newRoot=root;
            return root;
        }
        
        root.left=null;
        root.right=null;
        
        l.left=r;
        l.right=root;
        return l.right;
    }
}