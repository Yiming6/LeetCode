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
        Top to bottom。 Note to backtrack.
        O(n).
    */
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return new ArrayList<>();
        
        List<String> ans = new ArrayList<>();
        helper(root, ans, new StringBuilder());
        
        return ans;
    }
    
    private void helper(TreeNode root, List<String> list, StringBuilder sb) {
        if (root == null) return;
        
        sb.append(String.valueOf(root.val));
        
        if (root.left == null && root.right == null) {
            list.add(sb.toString());
            return;
        }
        
        sb.append("->");
        
        helper(root.left, list, new StringBuilder(sb));
        helper(root.right, list, new StringBuilder(sb));
    }
}