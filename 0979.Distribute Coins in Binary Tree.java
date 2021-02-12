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
        Bottom to top. Count the net total coins that a node can give or need.
    */
    
    int ans;
    
    public int distributeCoins(TreeNode root) {
        if (root == null) return 0;
        
        ans = 0;
        helper(root);
        
        return ans;
    }
    
    private int helper(TreeNode root) {
        if (root == null) return 0;
        
        int left = helper(root.left), right = helper(root.right);
        int count = left + right + root.val - 1;
        ans += Math.abs(count);
        
        return count;
    }
}