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
    public List<Integer> inorderTraversal(TreeNode root) {
        //Morris Traversal             Time: O(N) Space:O(1) if the output does not count towards the space complexity.
        List<Integer> ans=new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                ans.add(cur.val);
                cur = cur.right; // move to next right node
            }else{ // has a left subtree
                TreeNode pre = cur.left;
                while (pre.right != null) { // find rightmost
                    pre = pre.right;
                }
                pre.right = cur; // put cur after the pre node
                TreeNode temp = cur; // store cur node
                cur = cur.left; // move cur to the top of the new tree
                temp.left = null; // original cur left be null, avoid infinite loops
            }
        }
        return ans;
    }
    /******************************************************************Time: O(N) Space:O(N)
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        Deque<TreeNode> stack=new ArrayDeque<>();
        TreeNode cur=root;
        while(cur!=null || !stack.isEmpty()){
            while(cur !=null){
                stack.addLast(cur);
                cur=cur.left;
            }
            cur=stack.pollLast();
            ans.add(cur.val);
            cur=cur.right;
        }
        return ans;
    }
    *****************************************************************Time: O(N) Space:O(N)
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        dfs(root, ans);
        return ans;
    }
    private void dfs(TreeNode root, List<Integer> ans){
        if(root==null) return;
        dfs(root.left, ans);
        ans.add(root.val);
        dfs(root.right, ans);
    }
    */
}