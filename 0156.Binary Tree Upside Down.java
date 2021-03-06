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
        Tree manipulation. Top to bottom and has no relationship to right subtree.
        Created references of left and right subtree for root before go to left 
        subtree.
        O(n)
    */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return root;
        
        TreeNode left = root.left, right = root.right;
        TreeNode ans = upsideDownBinaryTree(root.left);
        
        left.left = right;
        left.right = root;
        root.left = null;
        root.right = null;
        
        return ans;
    }
}