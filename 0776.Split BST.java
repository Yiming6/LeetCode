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
    public TreeNode[] splitBST(TreeNode root, int target) {
        if (root == null) return new TreeNode[2];
        
        if (root.val == target) {
            TreeNode right = root.right;
            root.right = null;
            return new TreeNode[]{root, right};
        } else if (root.val < target) {
            TreeNode[] right = splitBST(root.right, target);
            root.right = right[0];
            return new TreeNode[]{root, right[1]};
        } else {
            TreeNode[] left = splitBST(root.left, target);
            root.left = left[1];
            return new TreeNode[]{left[0], root};
        }
    }
}