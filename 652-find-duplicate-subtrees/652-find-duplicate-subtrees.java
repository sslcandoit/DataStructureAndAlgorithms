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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans=new ArrayList<>();
        Map<String, Integer> map=new HashMap<>();
        helper(root, ans, map);
        return ans;
    }
    private String helper(TreeNode root, List<TreeNode> ans, Map<String, Integer> map){
        if(root==null) return "";
        String s="("+helper(root.left, ans, map)+root.val+helper(root.right, ans, map)+")";
        
        if(map.containsKey(s) && map.get(s)==1) ans.add(root);
        map.put(s, map.getOrDefault(s, 0)+1);
        
        return s;
    }
}