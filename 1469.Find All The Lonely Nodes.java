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
        Top to bottom.
    */
    public List<Integer> getLonelyNodes(TreeNode root) {
        if (root == null) return new ArrayList<>();
        
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        
        return ans;
    }
    
    private void helper(TreeNode root, List<Integer> list) {
        if (root == null) return;
        
        if (root.left == null && root.right != null) list.add(root.right.val);
        if (root.left != null && root.right == null) list.add(root.left.val);
        
        helper(root.left, list);
        helper(root.right, list);
    }
}