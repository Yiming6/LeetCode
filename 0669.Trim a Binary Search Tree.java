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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null || low > high) return null;
        
        TreeNode left = trimBST(root.left, low, high), right = trimBST(root.right, low, high);
        
        if ((root.val >= low && root.val <= high)) {
            root.left = left;
            root.right = right;
        } else if (left == null || right == null) {
            root = left == null ? right : left;
        } else {
            TreeNode curr = right;
            while (curr.left != null) curr = curr.left;
            curr.left = left;
            root = right;
        }
        
        return root;
    }
}