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
    
    int sum;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        
        sum = 0;
        helper(root);
        
        return root;
    }
    
    private void helper(TreeNode root) {
        if (root == null) return;
        
        helper(root.right);
        
        root.val += sum;
        sum = root.val;
        
        helper(root.left);
    }
}