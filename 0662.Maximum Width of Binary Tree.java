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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 1));
        
        int ans = 0;
        
        while (!queue.isEmpty()) {
            if (queue.size() == 1) queue.add(new Pair<>(queue.poll().getKey(), 1));
            int left = queue.peek().getValue(), right = left;
            for (int i = queue.size(); i > 0; i--) {
                Pair<TreeNode, Integer> curr = queue.poll();
                TreeNode node = curr.getKey();
                right = curr.getValue();
                if (node.left != null) queue.add(new Pair<>(node.left, curr.getValue() * 2));
                if (node.right != null) queue.add(new Pair<>(node.right, curr.getValue() * 2 + 1));
            }
            
            ans = Math.max(ans, right - left + 1);
        }
        
        return ans;
    }
}