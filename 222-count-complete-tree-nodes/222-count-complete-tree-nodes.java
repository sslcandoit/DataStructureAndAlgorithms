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
    public int countNodes(TreeNode root) {
        int left=countLeft(root);
        int right=countRight(root);
        
        if(left==right) return (1<<left)-1;
        else return 1+countNodes(root.left)+countNodes(root.right);
    }
    private int countLeft(TreeNode root){
        int ans=0;
        while(root !=null){
            root=root.left;
            ans++;
        }
        return ans;
    }
    private int countRight(TreeNode root){
        int ans=0;
        while(root !=null){
            root=root.right;
            ans++;
        }
        return ans;
    }
}