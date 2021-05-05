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
    TreeNode pre;
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        
        ans = Integer.MAX_VALUE;
        pre = null;
        
        helper(root);
        
        return ans;
    }
    
    private void helper(TreeNode root) {
        if (root == null) return;
        
        helper(root.left);
        
        if (pre != null) ans = Math.min(ans, root.val - pre.val);
        
        pre = root;
                
        helper(root.right);
    }
}