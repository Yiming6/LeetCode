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
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        
        ans = 0;
        helper(root);
        
        return ans;
    }
    
    public int[] helper(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        
        int dec = 1, inc = 1;
        int[] left = helper(root.left), right = helper(root.right);
        
        if (root.left != null) {
            if (root.val - root.left.val == 1) dec = Math.max(dec, left[0] + 1);
            if (root.val - root.left.val == -1) inc = Math.max(inc, left[1] + 1);
        }
        
        if (root.right != null) {
            if (root.val - root.right.val == 1) dec = Math.max(dec, right[0] + 1);
            if (root.val - root.right.val == -1) inc = Math.max(inc, right[1] + 1);
        }
        
        ans = Math.max(ans, dec + inc - 1);
        return new int[]{dec, inc};
    }
}