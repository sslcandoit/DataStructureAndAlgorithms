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
    public List<List<Integer>> levelOrder(TreeNode root) {     //Time: O(N) Space:O(N)
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        
        Deque<TreeNode> queue=new ArrayDeque<>();
        queue.push(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> subAns=new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode temp=queue.pollFirst();
                subAns.add(temp.val);
                if(temp.left!=null) queue.addLast(temp.left);
                if(temp.right!=null) queue.addLast(temp.right);
            }
            ans.add(subAns);
        }
        return ans;
    }
}