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
    public boolean isValidBST(TreeNode root) {
        if(root==null ||(root.left==null && root.right==null)) return true;
        return isBST(root, null, null);
    }
    private boolean isBST(TreeNode root, Integer low, Integer high){
        if(root==null) return true;
        
        if(low!=null && root.val<=low || high!=null && root.val>=high) return false;
        return isBST(root.left, low, root.val)&&isBST(root.right, root.val, high);
    }
}