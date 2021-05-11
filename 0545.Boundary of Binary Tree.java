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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null) return new ArrayList<>();
        
        List<Integer> ans = new ArrayList<>();
        ans.add(root.val);
        
        helper(root.left, true, false, ans);
        helper(root.right, false, true, ans);
        
        return ans;
    }
    
    private void helper(TreeNode root, boolean leftBound, boolean rightBound, List<Integer> list) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }
        
        if (leftBound) list.add(root.val);
        helper(root.left, leftBound && root.left != null, rightBound && root.right == null, list);
        helper(root.right, leftBound && root.left == null, rightBound && root.right != null, list);
        if (rightBound) list.add(root.val);
    }
}