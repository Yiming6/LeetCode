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
        Construct tree from any order.
        Using a global variety to record the current position in preorder. The increment of
        index in preorder array matches our preorder traversal. Every time we creat a node, 
        move forward 1 in preorder array.
        Using a hashmap to store the value and index of inorder traversal.
        After root index being found, using that map to determine range of left and right part
        in inorder traversal array.
    */
    
    int curr;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        
        int n = preorder.length;
        curr = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        
        return helper(preorder, map, 0, n - 1);
    }
    
    private TreeNode helper(int[] preorder, Map<Integer, Integer> map, int start, int end) {
        if (start > end) return null;
        // if (start == end) return new TreeNode(preorder[curr++]);
        
        int val = preorder[curr++];
        TreeNode root = new TreeNode(val);
        
        int index = map.get(val);
        
        root.left = helper(preorder, map, start, index - 1);
        root.right = helper(preorder, map, index + 1, end);
        
        return root;
    }
}