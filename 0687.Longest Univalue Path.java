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
    int ans;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        
        ans = 0;
        helper(root);
        
        return ans;
    }
    
    private int helper(TreeNode root) {
        if (root == null) return 0;
        
        int left = helper(root.left), right = helper(root.right);
        
        int leftCandi = root.left == null || root.val != root.left.val ? 0 : left + 1;
        int rightCandi = root.right == null || root.val != root.right.val ? 0 : right + 1;
        
        ans = Math.max(ans, leftCandi + rightCandi);
        
        return Math.max(leftCandi, rightCandi);
    }
}