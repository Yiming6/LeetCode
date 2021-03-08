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
        Bottom to top. Left flag is true when left child is null or left subtree is 
        true and root.val equals to left child val. The same as right. For leaf node,
        result + 1 and return true.
        O(n).
    */
    
    int ans;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        
        helper(root);
        
        return ans;
    }
    
    private boolean helper(TreeNode root) {        
        if (root.left == null && root.right == null) {
            ans++;
            return true;
        }
        
        boolean left = root.left == null || (helper(root.left) && root.val == root.left.val), right = root.right == null || (helper(root.right) && root.val == root.right.val);
        
        if (left && right) {
            ans++;
            return true;
        } else return false;
    }
}