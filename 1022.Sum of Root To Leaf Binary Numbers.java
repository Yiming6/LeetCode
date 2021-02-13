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
        Similiar to building string. dfs. Top to bottom.
        Note the way to convert binary string to integer.
    */
    
    int ans;
    
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) return 0;
        
        ans = 0;
        helper(root, "");
        
        return ans;
    }
    
    private void helper(TreeNode root, String binary) {
        if (root == null) return;
        
        binary += String.valueOf(root.val);
        
        if (root.left == null && root.right == null) {
            ans += Integer.parseInt(binary, 2);
            return;
        }
        
        helper(root.left, binary);
        helper(root.right, binary);
    }
}