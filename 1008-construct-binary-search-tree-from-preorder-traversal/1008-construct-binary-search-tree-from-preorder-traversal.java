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
    private int index=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, Integer.MAX_VALUE);
    }
    private TreeNode bstFromPreorder(int[] preorder, int bound) {
        if(index==preorder.length || preorder[index]>bound) return null;
        
        int root_val=preorder[index++];
        TreeNode newNode=new TreeNode(root_val);
        newNode.left=bstFromPreorder(preorder, root_val);
        newNode.right=bstFromPreorder(preorder, bound);
        return newNode;
    }
}