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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null) return root;
        
        Deque<TreeNode> queue=new ArrayDeque<>();
        queue.addLast(root);
        while(!queue.isEmpty()){
            TreeNode cur=queue.pollFirst();
            if(cur.val==val) return cur;
            if(cur.left!=null) queue.addLast(cur.left);
            if(cur.right!=null) queue.addLast(cur.right);
        }
        return null;
    }
}