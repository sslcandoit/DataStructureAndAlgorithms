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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder s=new StringBuilder(), d=new StringBuilder();
        findValue(root, startValue, s);
        findValue(root, destValue, d);
        s.reverse();
        d.reverse();
        int i=0, min_i=Math.min(s.length(), d.length());
        while(i<min_i && s.charAt(i)==d.charAt(i)) i++;
        return "U".repeat(s.length()-i)+d.substring(i).toString();
    }
    private boolean findValue(TreeNode root, int v, StringBuilder sb){
        if(root.val==v) return true;
        else if(root.left !=null && findValue(root.left, v, sb)) sb.append("L");
        else if(root.right !=null && findValue(root.right, v, sb)) sb.append("R");
        return sb.length()>0;
    }
}