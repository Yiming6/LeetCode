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
        Divide the tree to three parts by x and count the number of nodes in each.
        Compare which one has most number of nodes. Top to bottom.
    */
    
    int left;
    int right;
    
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        if (root == null || x > n || n % 2 == 0) return false;
        
        helper(root, x);
        
        return left > n - left || right > n - right || n - 1 - left - right > left + right + 1;
    }
    
    private void helper(TreeNode root, int x) {
        if (root == null) return;
        
        if (root.val == x) {
            left = count(root.left);
            right = count(root.right);
        }
        else {
            helper(root.left, x);
            helper(root.right, x);
        }
    }
    
    private int count(TreeNode root) {
        if (root == null) return 0;
        return count(root.left) + count(root.right) + 1;
    }
}