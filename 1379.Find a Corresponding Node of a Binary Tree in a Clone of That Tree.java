/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    /*
        HashMap.
    */
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (target == null) return null;
        
        Map<TreeNode, TreeNode> map = new HashMap<>();
        helper(original, cloned, map);
        
        return map.get(target);
    }
    
    private void helper(TreeNode original, TreeNode cloned, Map<TreeNode, TreeNode> map) {
        if (original == null || cloned == null) return;
        
        map.put(original, cloned);
        helper(original.left, cloned.left, map);
        helper(original.right, cloned.right, map);
    }
}