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
    public int findClosestLeaf(TreeNode root, int k) {
        if (root == null) return 0;
        
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        buildGraph(root, null, parent, queue, k);
        
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            
            if (visited.contains(curr)) continue;
            
            if (curr.left == null && curr.right == null) return curr.val;
            
            visited.add(curr);
            
            if (parent.get(curr) != null) queue.add(parent.get(curr));
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
        
        return -1;
    }
    
    private void buildGraph(TreeNode curr, TreeNode pre, Map<TreeNode, TreeNode> parent, Queue<TreeNode> queue, int k) {
        if (curr == null) return;
        
        parent.put(curr, pre);
        if (curr.val == k) queue.add(curr);
        
        buildGraph(curr.left, curr, parent, queue, k);
        buildGraph(curr.right, curr, parent, queue, k);
    }
}