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
        Depth problem. Bottom to top.
        If left subtree or right subtree is not balanced, return false;
        Otherwise check current root is balanced or not.
        O(n)
    */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        
        return left && right && Math.abs(helper(root.left) - helper(root.right)) <= 1;
    }
    
    private int helper(TreeNode root) {
        if (root == null) return 0;
        return Math.max(helper(root.left), helper(root.right)) + 1;
    }
    
}