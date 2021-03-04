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
        Top to bottom.
    */
    
    int ans;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        
        ans = 0;
        helper(root, 0);
        
        return ans;
    }
    
    private void helper(TreeNode root, int curr) {
        if (root == null) return;
        
        int sum = curr * 10 + root.val;
        
        if (root.left == null && root.right == null) ans += sum;
        helper(root.left, sum);
        helper(root.right, sum);
    }
}