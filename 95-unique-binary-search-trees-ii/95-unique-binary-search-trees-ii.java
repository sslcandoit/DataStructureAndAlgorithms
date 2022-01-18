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
    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<>();
        return helper(1, n);
    }
    private List<TreeNode> helper(int start, int end){
        List<TreeNode> list=new ArrayList<>();
        if(start>end){
            list.add(null);
            return list;
        } 
        for(int root=start; root<=end; root++){
            List<TreeNode> left=helper(start, root-1);
            List<TreeNode> right=helper(root+1, end);
        
            for(TreeNode l:left){
                for(TreeNode r:right){
                    TreeNode newNode=new TreeNode(root);
                    newNode.left=l;
                    newNode.right=r;
                    list.add(newNode);
                }
            }
        }
       return list; 
    }
}