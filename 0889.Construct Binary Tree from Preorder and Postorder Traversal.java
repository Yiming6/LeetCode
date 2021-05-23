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
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre.length == 0 || post.length == 0) return null;
        
        if (pre.length == 1 && post.length == 1) return new TreeNode(pre[0]);
        
        int left = pre[1], l = 0;
        
        while (l < post.length) if (post[l++] == left) break;
        
        TreeNode root = new TreeNode(pre[0]);
        
        root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, l + 1), Arrays.copyOfRange(post, 0, l));
        root.right = constructFromPrePost(Arrays.copyOfRange(pre, l + 1, pre.length), Arrays.copyOfRange(post, l, post.length - 1));
        
        return root;
    }
}