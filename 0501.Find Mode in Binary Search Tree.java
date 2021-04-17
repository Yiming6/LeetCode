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
    TreeNode pre;
    int max;
    int curr;
    
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        
        pre = null;
        max = curr = 1;
        Set<Integer> set = new HashSet<>();
        
        helper(root, set);
        
        int[] ans = new int[set.size()];
        int i = 0;
        for (int num : set) ans[i++] = num;
        
        return ans;
    }
    
    private void helper(TreeNode root, Set<Integer> set) {
        if (root == null) return;
        
        helper(root.left, set);
        
        if (pre != null) {
            if (pre.val == root.val) curr++;
            else curr = 1;
            
            if (curr >= max) {
                if (curr > max) set.clear();
                set.add(root.val);
                max = curr;
            }
        } else set.add(root.val);
        
        pre = root;
        
        helper(root.right, set);
    }
}