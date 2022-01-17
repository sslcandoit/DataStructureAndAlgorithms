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
        //Morris Traversal                    Time:O(N) Space:O(N) Space should be O(1),but output list contains N elements
        List<Integer> ans=new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                ans.add(cur.val);
                cur = cur.right;
            }else{
                TreeNode pre = node.left;
                while ((pre.right != null) && (pre.right != node)) pre = pre.right;
                if (pre.right == null) {
                    ans.add(cur.val);
                    pre.right = cur;
                    cur = cur.left;
                }else{
                    pre.right = null;
                    cur = cur.right;
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
