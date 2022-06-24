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
    public TreeNode increasingBST(TreeNode root) {
        return increasingBST(root, null);
    }

    public TreeNode increasingBST(TreeNode root, TreeNode tail) {
        if (root == null) return tail;
        TreeNode res = increasingBST(root.left, root);
        root.left = null;
        root.right = increasingBST(root.right, tail);
        return res;
    }
    /*
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
    */
}