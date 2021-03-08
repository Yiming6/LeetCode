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
        Count the number of nodes in left substree. If its number is k - 1, the root is
        what we want. if its number larget than k - 1, the target is in the left subtree.
        else it is in the right substree. Note the target will minus (left + 1) when we search
        in right subtree.
        O(n).
    */
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        
        int left = count(root.left);
        if (left == k - 1) return root.val;
        else if (left < k - 1) return kthSmallest(root.right, k - left - 1);
        else return kthSmallest(root.left, k);
    }
    
    private int count(TreeNode root) {
        if (root == null) return 0;
        return count(root.left) + count(root.right) + 1;
    }
}