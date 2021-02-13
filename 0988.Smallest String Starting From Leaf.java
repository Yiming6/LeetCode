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
        Backtrack. Top to bottom;
    */
    public String smallestFromLeaf(TreeNode root) {
        if (root == null) return "";
        
        List<String> list = new ArrayList<>();
        helper(root, list, new StringBuilder());
        Collections.sort(list);
        
        return list.get(0);
    }
    
    private void helper(TreeNode root, List<String> list, StringBuilder sb) {
        if (root == null) return;
        
        sb.append((char) (root.val + 97));
        
        if (root.left == null && root.right == null) {
            sb.reverse();
            list.add(sb.toString());
            return;
        }
        
        helper(root.left, list, new StringBuilder(sb));
        helper(root.right, list, new StringBuilder(sb));
    }
}