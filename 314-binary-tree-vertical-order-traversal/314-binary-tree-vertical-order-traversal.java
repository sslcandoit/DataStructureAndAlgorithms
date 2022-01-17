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
    class Node{
        int col;
        TreeNode root;
        public Node(int col, TreeNode root){
            this.col=col;
            this.root=root;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        
        Deque<Node> queue=new ArrayDeque<>();
        queue.addLast(new Node(0, root));
        
        Map<Integer, List<Integer>> map=new HashMap<>();
        int minCol=Integer.MAX_VALUE;
        int maxCol=Integer.MIN_VALUE;
        
        while(!queue.isEmpty()){
            Node temp=queue.pollFirst();
            int col=temp.col;
            TreeNode n=temp.root;
                
            minCol=Math.min(minCol, col);
            maxCol=Math.max(maxCol, col);
                
            if(!map.containsKey(col)) map.put(col, new ArrayList<>());
            map.get(col).add(n.val);
                
            if(n.left!=null) queue.addLast(new Node(col-1, n.left));
            if(n.right!=null) queue.addLast(new Node(col+1, n.right));
        }
        for(int i=minCol; i<=maxCol; i++){
            ans.add(map.get(i));
        }
        return ans;
    }
}