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
        The property of complete tree, every level has full nodes except last level.
        Count the most left depth and most right depth, if they are the same, all 
        level has full nodes, the total number of nodes is 2^depth - 1.
        Otherwise, count the nodes one by one.
        O(n).
    */
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        
        int left = countLeft(root);
        int right = countRight(root);
        
        if (left == right) return (int) Math.pow(2, left) - 1;
        else return count(root);
    }
    
    private int countLeft(TreeNode root) {
        if (root == null) return 0;
        return countLeft(root.left) + 1;
    }
    
    private int countRight(TreeNode root) {
        if (root == null) return 0;
        return countRight(root.right) + 1;
    }
    
    private int count(TreeNode root) {
        if (root == null) return 0;
        return count(root.left) + count(root.right) + 1;
    }
}