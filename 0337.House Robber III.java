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
        DP in binary tree. Bottom to top. every time return two values, include and exclude.
        Include represent the maximum value containing the value of this node.
        Exclude represent the maximum value till now that doesn't contain current value
        O(n).
    */
    public int rob(TreeNode root) {
        if (root == null) return 0;
        
        int[] ans = helper(root);
        return Math.max(ans[0], ans[1]);
    }
    
    private int[] helper(TreeNode root) {
        if (root == null) return new int[2];
        
        int[] left = helper(root.left), right = helper(root.right);
        
        int include = root.val + left[1] + right[1];
        int exclude = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        
        return new int[]{include, exclude};
    }
}