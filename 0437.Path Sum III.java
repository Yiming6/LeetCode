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
        For every node, it may be the starter of the path, it may not. So for each node, we
        run a function to check whether it is the starter, in the same time, we do the 
        same thing to its subtrees. Note that the value can be negative, so we cannot stop
        even current sum is 0;
        O(n!).
    */
    int ans = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        
        goDown(root, sum);
        
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        
        return ans;
    }
    
    private void goDown(TreeNode root, int sum) {
        if (root == null) return;
        
        if (root.val == sum) ans++;
        
        goDown(root.left, sum - root.val);
        goDown(root.right, sum - root.val);
    }
}