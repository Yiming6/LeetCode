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
    /*
        Convert binary tree to linked list. Bottom to top.
    */
    public void flatten(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        
        helper(root);
    }
    
    private TreeNode helper(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
                
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);
        
        if (left == null) {
            root.right = right;
            return root;
        }
        
        root.right = left;
        root.left = null;
        
        while (left.right != null) left = left.right;
        
        left.right = right;

        return root;
    }
}