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
    int sum;
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        
        this.sum=0;
        helper(root, 0);
        return sum;
    }
    private void helper(TreeNode root, int pre){
        if(root.left==null && root.right==null){
            sum+=pre*10+root.val;
            return;
        }
        if(root.left !=null) helper(root.left, pre*10+root.val);
        if(root.right !=null) helper(root.right, pre*10+root.val);
    }
}