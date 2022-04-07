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
    public TreeNode deleteNode(TreeNode root, int key) {
    if(root == null) return null;
    
    if(key<root.val) root.left = deleteNode(root.left, key);
    else if(key>root.val) root.right = deleteNode(root.right, key);
    else{
        if(root.left==null) return root.right;
        else if(root.right==null) return root.left;
        
        TreeNode minNode=root.right;
        while(minNode.left != null) minNode = minNode.left;
        root.val = minNode.val;
        root.right = deleteNode(root.right, root.val);
    }
    return root;
}
    /*
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return root;
        
        if(key<root.val) root.left=deleteNode(root.left, key);
        else if(key>root.val) root.right=deleteNode(root.right, key);
        else{
            if(root.left==null) return root.right;
            else if(root.right==null) return root.left;
            
            TreeNode newNode=root.right;
            if(newNode.left==null) root.right=newNode.right;
            else{
                TreeNode pre=null;
                while(newNode.left !=null){
                    pre=newNode;
                    newNode=newNode.left;
                } 
                pre.left=newNode.right;
            }
            newNode.left=root.left;
            newNode.right=root.right;
            return newNode;
        }
        return root;
    }
    */
}