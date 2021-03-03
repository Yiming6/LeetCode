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
        Path from root to leaf. dfs. Top to bottom.
        Remember to back track.
    */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return new ArrayList<>();
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        helper(root, targetSum, ans, list);
        
        return ans;
    }
    
    private void helper(TreeNode root, int targetSum, List<List<Integer>> ans, List<Integer> list) {
        if (root == null) return;
        
        list.add(root.val);
        
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) ans.add(new ArrayList<>(list));
        }
        
        helper(root.left, targetSum - root.val, ans, list);
        helper(root.right, targetSum - root.val, ans, list);
        
        list.remove(list.size() - 1);
    }
}