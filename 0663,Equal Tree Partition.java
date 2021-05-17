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
    boolean ans;
    public boolean checkEqualTree(TreeNode root) {
        if (root == null) return false;
        
        ans = false;
        int sum = total(root);
        
        if (sum % 2 == 1) return false;
        int left = helper(root.left, sum), right = helper(root.right, sum);
        
        if (ans || (root.left != null) && sum - left == left || (root.right != null) && sum - right == right) return true;
        
        return false;
    }
    
    private int total(TreeNode root) {
        if (root == null) return 0;
        return total(root.left) + total(root.right) + root.val;
    }
    
    private int helper(TreeNode root, int sum) {
        if (root == null || ans) return 0;
        
        int curr = helper(root.left, sum) + helper(root.right, sum) + root.val;
        
        if (sum - curr == curr) {
            ans = true;
            return 0;
        }
        
        return curr;
    } 
}