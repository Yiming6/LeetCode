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
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        
        boolean left = root.left == null ? true : root.val == root.left.val && isUnivalTree(root.left);
        boolean right = root.right == null ? true : root.val == root.right.val && isUnivalTree(root.right);
        
        return left && right;
    }
}