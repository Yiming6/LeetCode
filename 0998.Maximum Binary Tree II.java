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
        Insert into binary tree. Top to bottom.
    */
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        
        if (root.val < val) {
            TreeNode ans = new TreeNode(val);
            ans.left = root;
            return ans;
        }
        
        root.right = insertIntoMaxTree(root.right, val);
        return root;
    }
}