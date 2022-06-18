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
    public TreeNode str2tree(String s) {
        if(s==null || s.length()==0) return null;
        Stack<TreeNode> stack=new Stack<>();
        int n=s.length();
        for(int r=0; r<n; r++){
            int l=r;
            char cur=s.charAt(r);
            if(cur=='(') continue;
            else if(cur==')') stack.pop();
            else{
                while(r+1<n && s.charAt(r+1)>='0' && s.charAt(r+1)<='9') r++;
                TreeNode newNode=new TreeNode(Integer.parseInt(s.substring(l, r+1)));
                
                if(!stack.isEmpty()){
                    TreeNode parent=stack.peek();
                    if(parent.left==null) parent.left=newNode;
                    else parent.right=newNode;
                }
                stack.push(newNode);
            }
        }
        return stack.pop();
    }
}