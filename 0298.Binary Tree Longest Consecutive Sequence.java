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
        bottom to top. return 0 in null and all leaf will return 1. if left child is
        not null and root value equals to left child value minus 1, left route 
        increase 1, otherwise right route increase 1. Keep the ans the maximum value.
        O(n).
    */
    
    int ans;
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        
        ans = 1;
        helper(root);
        
        return ans;
    }
    
    private int helper(TreeNode root) {
        if (root == null) return 0;
        
        int left = helper(root.left), right = helper(root.right);
        
        if (left == 0 && right == 0) return 1;
        
        if (left != 0) left = root.val == root.left.val - 1 ? left + 1 : 1;
        if (right != 0) right = root.val == root.right.val - 1 ? right + 1 : 1;
        
        ans = Math.max(ans, Math.max(left, right));
        
        return Math.max(left, right);
    }
}