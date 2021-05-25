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
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        
        List<TreeNode> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            
            list.add(curr);
            
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
        
        for (int i = 0; i < list.size(); i++) {
            TreeNode curr = list.get(i);
            
            if ((i + 1) * 2 <= list.size() && (curr.left != list.get((i + 1) * 2 - 1))) return false;
            if ((i + 1) * 2 + 1 <= list.size() && (curr.right != list.get((i + 1) * 2))) return false;
            
        }
        
        return true;
    }
}