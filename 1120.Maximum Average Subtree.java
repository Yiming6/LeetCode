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
        Calculating the average value of each subtree and return sum and numbers of treenode
        of each subtree. Bottom to top.
    */
    
    double ans;
    
    public double maximumAverageSubtree(TreeNode root) {
        if (root == null) return 0;
        
        ans = 0;
        helper(root);
        
        return ans;
    }
    
    private double[] helper(TreeNode root) {
        if (root == null) return new double[]{0, 0};
        
        double[] left = helper(root.left);
        double[] right = helper(root.right);
        
        double sum = left[0] + right[0] + (double)root.val, num = left[1] + right[1] + 1;
        ans = Math.max(ans, sum / num);
        
        return new double[]{sum, num};
    }
}