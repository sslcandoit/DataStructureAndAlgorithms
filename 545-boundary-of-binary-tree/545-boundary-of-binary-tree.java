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
    private List<Integer> ans=new ArrayList<>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root==null) return ans;
        
        ans.add(root.val);
        leftBoundary(root.left);
        leaves(root.left);
        leaves(root.right);
        rightBoundary(root.right);
        return this.ans;
    }
    private void leftBoundary(TreeNode root){
        if(root==null || (root.left==null && root.right==null)) return;
        
        ans.add(root.val);
        if(root.left !=null) leftBoundary(root.left);
        else if(root.right !=null) leftBoundary(root.right);
    }
    private void leaves(TreeNode root){
        if(root==null) return;
        
        if(root.left==null && root.right==null) ans.add(root.val);
        leaves(root.left);
        leaves(root.right);
    }
    private void rightBoundary(TreeNode root){
        if(root==null || (root.left==null && root.right==null)) return;
        
        if(root.right!=null) rightBoundary(root.right);
        else if(root.left !=null) rightBoundary(root.left);
        ans.add(root.val);
    }
}