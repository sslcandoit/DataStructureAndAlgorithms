/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private Map<Integer, List<Integer>> graph;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        this.graph=new HashMap<>();
        List<Integer> ans=new ArrayList<>();
        if(k==0){
            ans.add(target.val);
            return ans;
        }
        buildGraph(root, null);
        Set<Integer> visited=new HashSet<>();
        visited.add(target.val);
        Queue<Integer> q=new LinkedList<>();
        q.offer(target.val);
        while(!q.isEmpty() && k>0){
            int size=q.size();
            for(int i=0; i<size; i++){
                List<Integer> cur=graph.get(q.poll());
                for(int adj:cur){
                    if(!visited.contains(adj)){
                        q.offer(adj);
                        visited.add(adj);
                    } 
                }
            }
            k--;
        }
        while(!q.isEmpty()) ans.add(q.poll());
        return ans;
    }
    private void buildGraph(TreeNode root, TreeNode par){
        if(root==null) return;
        if(!graph.containsKey(root.val)) graph.put(root.val, new ArrayList<>());
        if(par !=null){
            graph.get(root.val).add(par.val);
            graph.get(par.val).add(root.val);
        }
        buildGraph(root.left, root);
        buildGraph(root.right, root);
    }
}