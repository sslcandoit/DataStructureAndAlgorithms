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
    int sum=0;
    public int sumRootToLeaf(TreeNode root) {
        helper(root, 0);
        return this.sum;
    }
    private void helper(TreeNode root, int cur){
        if(root.left==null && root.right==null){
            this.sum+=cur*2+root.val;
            return;
        }
        if(root.left !=null) helper(root.left, cur*2+root.val);
        if(root.right !=null) helper(root.right, cur*2+root.val);
    }
}