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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return helper(root).getKey();
    }
    
    private Pair<TreeNode, Integer> helper(TreeNode root) {
        if (root == null) return new Pair<>(null, 0);
        
        Pair<TreeNode, Integer> left = helper(root.left) , right = helper(root.right);
        
        TreeNode n1 = left.getKey(), n2 = right.getKey();
        int d1 = left.getValue(), d2 = right.getValue();
        
        return new Pair<>(d1 == d2 ? root : d1 > d2 ? n1 : n2, Math.max(d1, d2) + 1);
    }
}