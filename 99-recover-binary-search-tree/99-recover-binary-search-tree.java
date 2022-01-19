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
    public void recoverTree(TreeNode root) {
        boolean firstSeen=true;
        TreeNode a=null;
        TreeNode b=null;
        TreeNode pre=new TreeNode(Integer.MIN_VALUE);
        
        while(root!=null){
            if(root.left!=null){
                TreeNode temp=root.left;
                while(temp.right!=null && temp.right!=root) temp=temp.right;
                if(temp.right==null){
                    temp.right=root;
                    root=root.left;
                }else{
                    temp.right=null;
                    if(pre.val>root.val && firstSeen){
                        a=pre;
                        firstSeen=false;
                    }
                    if(pre.val>root.val && !firstSeen) b=root;
                    pre=root;
                    root=root.right;
                }
            }else{
                if(pre.val>root.val && firstSeen){
                    a=pre;
                    firstSeen=false;
                }
                if(pre.val>root.val && !firstSeen) b=root;
                pre=root;
                root=root.right;
            }
        }
        int x=a.val;
        a.val=b.val;
        b.val=x;
    }
}