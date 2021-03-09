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
        Given binary search tree, set a candidate, if current value > target, the result may 
        in left subtree. Similarly, if current value < target, the result may be in right 
        subtree. But remember to compare with root value. That's the reason why it is being
        called candidate.
        O(n).
    */
    public int closestValue(TreeNode root, double target) {
        if (root == null) return 0;
        
        int candi = 0, curr = root.val;
        
        if (curr > target) {
            if (root.left == null) return curr;
            candi = closestValue(root.left, target);
        } else if (curr < target) {
            if (root.right == null) return curr;
            candi = closestValue(root.right, target);
        }
        
        return Math.abs((double)candi - target) < Math.abs((double)curr - target) ? candi : curr;
    }
}