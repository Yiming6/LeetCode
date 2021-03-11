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
        Bottom to top. return an array that contains the minimum, maximum and number of nodes
        in the subtree. If root.val > max of left subtree and < min of right subtree, this is
        a bst and return the total min and max and number to upper level.
        O(n).
    */
    
    int ans;
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        
        ans = 0;
        helper(root);
        
        return ans;
    }
    
    private int[] helper(TreeNode root) {
        if (root == null) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        
        int[] left = helper(root.left), right = helper(root.right);
        
        if (root.val > left[1] && root.val < right[0]) {
            ans = Math.max(ans, left[2] + right[2] + 1);
            return new int[]{Math.min(left[0], root.val), Math.max(right[1], root.val), left[2] + right[2] + 1};
        }
        
        return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
    }
}