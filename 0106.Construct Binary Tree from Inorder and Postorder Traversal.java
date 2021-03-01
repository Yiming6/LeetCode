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
        Similar to question 105, but it is postorder traversal. We can start from end of 
        postorder array. Note construct right subtree and then left subtree.
        Although we can make postorder traversal, the tree must be constructed from top to
        bottom. Thun, we need to do reverse postorder traversal.
    */
    
    int curr;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        
        int n = postorder.length;
        curr = n - 1;
        return helper(postorder, map, 0, n - 1);
    }
    
    private TreeNode helper(int[] postorder, Map<Integer, Integer> map, int start, int end) {
        if (start > end) return null;
        
        int val = postorder[curr--];
        TreeNode root = new TreeNode(val);
        
        int index = map.get(val);
        root.right = helper(postorder, map, index + 1, end);
        root.left = helper(postorder, map, start, index - 1);
        
        return root;
    }
}