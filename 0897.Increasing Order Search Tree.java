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
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;
        
        List<TreeNode> list = new ArrayList<>();
        helper(root, list);
        
        for (int i = 0; i < list.size(); i++) {
            TreeNode curr = list.get(i);
            
            if (i != list.size() - 1) {
                curr.left = null;
                curr.right = list.get(i + 1);
            } else {
                curr.left = null;
                curr.right = null;
            }
        }
        
        return list.get(0);
    }
    
    private void helper(TreeNode root, List<TreeNode> list) {
        if (root == null) return;
        
        helper(root.left, list);
        list.add(root);
        helper(root.right, list);
    }
}