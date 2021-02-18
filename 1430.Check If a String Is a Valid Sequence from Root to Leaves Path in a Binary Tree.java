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
        Similar to question that compar linked list and binary tree but easier. 
        The starter is fixed which is root and ending is leaf. So we just need to 
        compare from root and beginning of array one by one.
        Top to bottom.
    */
    public boolean isValidSequence(TreeNode root, int[] arr) {
        if (root == null && arr.length == 0) return true;
        if (root == null || arr.length == 0) return false;
                
        return helper(root, arr, 0);
    }
    
    private boolean helper(TreeNode root, int[] arr, int i) {
        if (root == null || i >= arr.length) return false;
        
        if (root.left == null && root.right == null) return i == arr.length - 1 && root.val == arr[i];
        
        if (root.val != arr[i]) return false;
        return helper(root.left, arr, i + 1) || helper(root.right, arr, i + 1);
    }
}