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
        HashMap with dfs. Top to bottom. Remeber backtrack.
    */
    
    int ans;
    public int pseudoPalindromicPaths (TreeNode root) {
        if (root == null) return 0;
        
        ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        helper(root, map);
        
        return ans;
    }
    
    private void helper(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return;
        
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        
        if (root.left == null && root.right == null) {
            int count = 0;
            for (int key : map.keySet()) {
                if (map.get(key) % 2 == 1) count++;
            }
            if (count == 0 || count == 1) ans++;
        }
        
        helper(root.left, map);
        helper(root.right, map);
        
        map.put(root.val, map.get(root.val) - 1);
    }
}