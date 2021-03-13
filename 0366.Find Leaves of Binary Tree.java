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
        Bottom to top.
        O(n!)
    */
    public List<List<Integer>> findLeaves(TreeNode root) {
        if (root == null) return new ArrayList<>();
        
        List<List<Integer>> ans = new ArrayList<>();
        while (root != null) {
            List<Integer> list = new ArrayList<>();
            root = helper(root, list);
            ans.add(list);
        }
        
        return ans;
    }
    
    private TreeNode helper(TreeNode root, List<Integer> list) {
        if (root == null) return null;
        if (root.left == null && root.right == null) {list.add(root.val); return null;}
        
        TreeNode left = helper(root.left, list), right = helper(root.right, list);
        root.left = left;
        root.right = right;
        
        return root;
    }
}