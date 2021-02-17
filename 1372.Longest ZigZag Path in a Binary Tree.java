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
        Top to bottom and taking every node as starter to search will be time limit exceeded.
        Bottom to top. Using a globa variety to record the maximum in each node as if it
        is the starter. Returning left result or right result depending on the flag.
    */
    
    int ans;
    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        
        ans = 0;
        int left = helper(root.left, true);
        int right = helper(root.right, false);
        
        ans = Math.max(ans, Math.max(left, right));
        
        return ans;
    }
    
    private int helper(TreeNode root, boolean isLeft) {
        if (root == null) return 0;
        
        int left = helper(root.left, true), right = helper(root.right, false);
        
        ans = Math.max(ans, Math.max(left, right));
                
        return isLeft ? right + 1 : left + 1;
    }
}