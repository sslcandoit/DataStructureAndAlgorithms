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
    private int max = 1;
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        List<Integer> leftSide=new ArrayList<>();
        helper(root, 0, 1, leftSide);
        return max;
    }
    private void helper(TreeNode root, int level, int index, List<Integer> leftSide){
        if(root==null) return;
        if(level==leftSide.size()) leftSide.add(index);
        
        this.max=Math.max(this.max, index-leftSide.get(level)+1);
        helper(root.left, level+1, index*2, leftSide);
        helper(root.right, level+1, index*2+1, leftSide);
    }
}