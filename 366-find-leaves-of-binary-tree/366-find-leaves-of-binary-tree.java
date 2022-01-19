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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        while(root!=null){
            List<Integer> list=new ArrayList<>();
            root=dfs(root, list);
            ans.add(list);
        } 
        return ans;
    }
    private TreeNode dfs(TreeNode root, List<Integer> list){
        if(root.left==null && root.right==null){
            list.add(root.val);
            return null;
        } 
        if(root.left!=null) root.left=dfs(root.left, list);
        if(root.right!=null) root.right=dfs(root.right, list);
        return root;
    }
}