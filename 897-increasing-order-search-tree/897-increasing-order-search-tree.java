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
    TreeNode head=null, pre=null;
    public TreeNode increasingBST(TreeNode root) {
        helper(root);
        return this.head;
    }
    private void helper(TreeNode root){
        if(root==null) return;
        
        helper(root.left);
        
        if(this.head==null) head=root;
        else pre.right=root;
        
        pre=root;
        root.left=null;
            
        helper(root.right);
    }
}