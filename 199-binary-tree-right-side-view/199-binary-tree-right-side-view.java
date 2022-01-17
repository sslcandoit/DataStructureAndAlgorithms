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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        Deque<TreeNode> queue=new ArrayDeque<>();
        queue.addLast(root);
        
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0; i<size; i++){
                TreeNode temp=queue.pollFirst();
                
                if(temp.left!=null) queue.addLast(temp.left);
                if(temp.right!=null) queue.addLast(temp.right);
                
                if(i==size-1) ans.add(temp.val);
            }
        }
        return ans;
    }
}