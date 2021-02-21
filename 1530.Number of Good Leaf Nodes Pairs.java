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
        Binary Tree to graph then dfs. 
    */
    
    int ans;
    public int countPairs(TreeNode root, int distance) {
        if (root == null) return 0;
        
        ans = 0;
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        Set<TreeNode> leaves = new HashSet<>();
        
        helper(root, parents, leaves);
        
        for (TreeNode leaf : leaves) {
            dfs(parents, leaf, null, 0, distance);
        }
        
        return ans / 2;
    }
    
    private void helper(TreeNode root, Map<TreeNode, TreeNode> map, Set<TreeNode> set) {
        if (root == null) return;
        if (root.left == null && root.right == null) set.add(root);
        
        if (root.left != null) map.put(root.left, root);
        if (root.right != null) map.put(root.right, root);
        
        helper(root.left, map, set);
        helper(root.right, map, set);
    }
    
    private void dfs(Map<TreeNode, TreeNode> parents, TreeNode curr, TreeNode pre, int dis, int max) {
        if (dis > max) return;
        if (dis != 0 && curr.left == null && curr.right == null) {
            ans++;
            return;
        }
        
        if (parents.containsKey(curr) && parents.get(curr) != pre) dfs(parents, parents.get(curr), curr, dis + 1, max);
        if (curr.left != null && curr.left != pre) dfs(parents, curr.left, curr, dis + 1, max);
        if (curr.right != null && curr.right != pre) dfs(parents, curr.right, curr, dis + 1, max);
    }
}