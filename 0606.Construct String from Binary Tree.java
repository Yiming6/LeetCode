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
    public String tree2str(TreeNode root) {
        if (root == null) return new String();
        
        String left = tree2str(root.left), right = tree2str(root.right);
        
        if (left.length() == 0 && right.length() == 0) return String.valueOf(root.val);
        
        if (left.length() == 0){
            left = "()";
            right = "(" + right + ")";
        } else if (right.length() == 0) left = "(" + left + ")";
        else {
            left = "(" + left + ")";
            right = "(" + right + ")";
        }
        
        return String.valueOf(root.val) + left + right;
    }
}