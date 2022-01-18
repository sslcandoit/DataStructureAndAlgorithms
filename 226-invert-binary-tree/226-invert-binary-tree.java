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
    public TreeNode invertTree(TreeNode root) {
        if(root==null ||(root.left==null && root.right==null)) return root;
        
        TreeNode l=invertTree(root.left);
        TreeNode r=invertTree(root.right);
        TreeNode temp=l;
        l=r;
        r=temp;
        root.left=l;
        root.right=r;
        
        return root;
    }
}