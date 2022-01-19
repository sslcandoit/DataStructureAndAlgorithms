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
    private Map<Integer, List<TreeNode>> map=new HashMap<>();
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> ans=new ArrayList<>();
        if(n%2==0) return ans;
        
        if(!map.containsKey(n)){
            if(n==1) ans.add(new TreeNode(0));
            else{
                for(int l=1; l<n; l+=2){
                    for(TreeNode i: allPossibleFBT(l)){
                        for(TreeNode j: allPossibleFBT(n-1-l)){
                            TreeNode newNode=new TreeNode(0);
                            newNode.left=i;
                            newNode.right=j;
                            ans.add(newNode);
                        }
                    }
                }
            }
            map.put(n, ans);
        } 
        return map.get(n);
    }
}