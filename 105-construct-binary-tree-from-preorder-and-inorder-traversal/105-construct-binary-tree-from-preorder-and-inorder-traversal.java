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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root=helper(0, 0, inorder.length-1, preorder, inorder);
        return root;
    } 
    public TreeNode helper(int pre_i, int in_start, int in_end, int[] preorder, int[] inorder){
        if(pre_i>=preorder.length || in_start>in_end) return null;
        TreeNode root=new TreeNode(preorder[pre_i]);
        
        int root_i=0;
        for(int i=in_start; i<=in_end; i++){
            if(inorder[i]==root.val){
                root_i=i;
                break;
            } 
        }
        root.left=helper(pre_i+1, in_start, root_i-1, preorder, inorder);
        root.right=helper(pre_i+(root_i - in_start)+1, root_i+1, in_end, preorder, inorder);
        return root;
    }
}