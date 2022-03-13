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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }   
    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) return null;
    
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0; 
        for (int i = inStart; i <= inEnd; i++) {//找到目前的根的值在中序遍历中是第几个
            if (inorder[i] == root.val) inIndex = i;
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }
    /*
Our aim is to find out the index of right child for current node in the preorder array
    
We know the index of current node in the preorder array - preStart, it's the root of a subtree
    
Remember pre order traversal always visit all the node on left branch before going to the right, therefore, we can get the immediate right child index by skipping all the node on the left branches/subtrees of current node
    
The inorder array has this information exactly. Remember when we found the root in "inorder" array we immediately know how many nodes are on the left subtree and how many are on the right subtree
    
Therefore the immediate right child index is preStart + numsOnLeft(numsOnLeft = root - inStart) + 1 (remember in preorder traversal array root is always ahead of children nodes but you don't know which one is the left child which one is the right, and this is why we need inorder array)
    */
}