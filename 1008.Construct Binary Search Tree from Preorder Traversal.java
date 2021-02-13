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
        Construct tree. Divide the array to two parts. Top to bottom.
    */
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) return null;
        if (preorder.length == 1) return new TreeNode(preorder[0]);
        
        return helper(preorder, 0, preorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, int s, int e) {
        if (s > e) return null;
        if (s == e) return new TreeNode(preorder[s]);
        
        TreeNode root = new TreeNode(preorder[s]);
        int ls = s + 1, le = 0, rs = 0, re = e, index = s;
        
        // the beginning of right subtree is the first number that larger than current head
        while (++index < preorder.length && preorder[index] <= root.val) {}
        
        le = index - 1;
        rs = index;
        
        root.left = helper(preorder, ls, le);
        root.right = helper(preorder, rs, re);
        
        return root;
    }
}