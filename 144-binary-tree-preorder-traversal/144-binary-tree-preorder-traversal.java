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
    public List<Integer> preorderTraversal(TreeNode root) {
        //Time:O(N) Space:O(N) Space should be O(1),but output list contains N elements
        List<Integer> ans=new ArrayList<>();
        TreeNode node = root;
        while (node != null) {
            if (node.left == null) {
                ans.add(node.val);
                node = node.right;
            }else{
                TreeNode predecessor = node.left;
                while ((predecessor.right != null) && (predecessor.right != node)) predecessor = predecessor.right;
                if (predecessor.right == null) {
                    ans.add(node.val);
                    predecessor.right = node;
                    node = node.left;
                }else{
                    predecessor.right = null;
                    node = node.right;
                }
            }
        }
        return ans;
    }
    /********************************************************************Time:O(N) Space:O(N)
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        Deque<TreeNode> stack=new ArrayDeque<>();
        stack.addLast(root);
        while(!stack.isEmpty()){
            TreeNode cur=stack.pollLast();
            ans.add(cur.val);
            if(cur.right!=null) stack.addLast(cur.right);
            if(cur.left!=null) stack.addLast(cur.left); 
        }
        return ans;             
    **********************************************************************Time:O(N) Space:O(N)
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        dfs(root, ans);
        return ans;
    }
    private void dfs(TreeNode root, List<Integer> ans){
        if(root==null) return;
        ans.add(root.val);
        dfs(root.left, ans);
        dfs(root.right, ans);
    }                                                                         */
}