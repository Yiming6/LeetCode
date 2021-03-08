/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /*
        Bottom to top. if root is p or q, return this root. if target is not in the 
        left subtree, return right, if target is not in the right subtree, return left.
        if we found either in left or right subtree, current root is the answer.
        O(n).
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q), right = lowestCommonAncestor(root.right, p, q);
        
        if (root.val == p.val || root.val == q.val) return root;
        
        if (left == null) return right;
        else if (right == null) return left;
        else return root;
    }
}