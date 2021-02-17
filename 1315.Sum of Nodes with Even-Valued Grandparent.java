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
        Tree to graph by using hashmap to record parent nodes.
        Top to bottom.
    */
    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) return 0;
        
        Map<TreeNode, TreeNode> map = new HashMap<>();
        
        helper(root, map);
        
        int ans = 0;
        for (TreeNode curr : map.keySet()) {
            TreeNode grandpa = map.get(map.get(curr));
            if (grandpa != null && grandpa.val % 2 == 0) ans += curr.val;
        }
        
        return ans;
    }
    
    private void helper(TreeNode root, Map<TreeNode, TreeNode> map) {
        if (root == null) return;
        
        if (root.left != null) map.put(root.left, root);
        if (root.right != null) map.put(root.right, root);
        
        helper(root.left, map);
        helper(root.right, map);
    }
}