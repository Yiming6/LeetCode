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
		Recursively traversal binary tree. Top to bottom.
	*/
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        
        boolean left = root.left == null ? true : root.val == root.left.val;
        boolean right = root.right == null ? true : root.val == root.right.val;
        
        return left && right && isUnivalTree(root.left) && isUnivalTree(root.right);
    }
}