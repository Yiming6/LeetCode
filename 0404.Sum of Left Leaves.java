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
        Set a flag in tree to represent left subtree. If it is the leaf and left subtree, add
        its value to final answer. Top to bottom.
        O(n).
    */
    
    int ans;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        
        ans = 0;
        helper(root, false);
        
        return ans;
    }
    
    private void helper(TreeNode root, boolean isLeft) {
        if (root == null) return;
        
        if (root.left == null && root.right == null && isLeft) ans += root.val;
        
        helper(root.left, true);
        helper(root.right, false);
    }
}