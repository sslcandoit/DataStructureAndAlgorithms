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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> ans=new LinkedList<>();
        if(root==null) return ans;
        Deque<TreeNode> queue=new ArrayDeque<>();
        queue.addLast(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> subAns=new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode temp=queue.pollFirst();
                subAns.add(temp.val);
                if(temp.left!=null) queue.addLast(temp.left);
                if(temp.right!=null) queue.addLast(temp.right);
            }
            ans.add(0, subAns);
        }
        return ans;
    }
}