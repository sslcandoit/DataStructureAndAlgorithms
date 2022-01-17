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
    public List<Integer> postorderTraversal(TreeNode root) {
        //Morries Traversal                                 Time:O(N) Space:O(1)
        Deque<Integer> res = new ArrayDeque<>();
        if (root == null) return new ArrayList<>(res);
		TreeNode cur = root;
		while (cur != null){
			if (cur.right != null) {
				TreeNode pre = cur.right;
				while (pre.left != null && pre.left != cur) pre = pre.left;
				if (pre.left == null) {
					pre.left = cur;
					res.addFirst(cur.val);
					cur = cur.right;
				}else{
					pre.left = null;
					cur = cur.left;
				}
			}else{
				res.addFirst(cur.val);
				cur = cur.left;
			}
		}
		return new ArrayList<>(res);
	}
    /*************************************************************Time:O(N) Space:O(N)
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> ans=new LinkedList<>();
        if(root==null) return ans;
        Deque<TreeNode> stack=new ArrayDeque<>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null){
            if(cur != null) {
                stack.push(cur);
                ans.addFirst(cur.val);       // Reverse the process of preorder
                cur = cur.right;             // Reverse the process of preorder
            } else {
                TreeNode node = stack.poll();
                cur = node.left;           // Reverse the process of preorder
            }
        }
        return ans;
    }
    /************************************************************Time:O(N) Space:O(N)
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        dfs(root, ans);
        return ans;
    }
    private void dfs(TreeNode root, List<Integer> ans){
        if(root==null) return;
        dfs(root.left, ans);
        dfs(root.right, ans);
        ans.add(root.val);
    }
    */
}