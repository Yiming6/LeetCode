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
        Find the mid point of nums array as the root node. Let left part to construct 
        left subtree and right part to construct right subtree.
        Top to bottom.
    */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        
        return helper(nums, 0, nums.length - 1);
    }
    
    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end) return null;
        
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        
        root.left = helper(nums, start, mid - 1);
        root.right = helper(nums, mid + 1, end);
        
        return root;
    }
}