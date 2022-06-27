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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        helper(root, targetSum, ans, new ArrayList<>(), 0);
        return ans;
    }
    private void helper(TreeNode root, int target, List<List<Integer>> ans, List<Integer> list, int sum){
        if(root.left==null && root.right==null){
            if(sum+root.val==target){
                list.add(root.val);
                ans.add(new ArrayList<>(list));
                list.remove(list.size()-1);
            }
            return;
        }
        list.add(root.val);
        sum+=root.val;
        if(root.left !=null) helper(root.left, target, ans, list, sum);
        if(root.right !=null) helper(root.right, target, ans, list, sum);
        
        list.remove(list.size()-1);
    }
}