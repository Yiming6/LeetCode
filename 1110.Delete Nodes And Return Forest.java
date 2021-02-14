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
        Top to bottom. Adding a flag to clarify whether this node should be added or not.
    */
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null) return new ArrayList<>();
        if (to_delete.length == 0) return new ArrayList<>(Arrays.asList(root));
        
        List<TreeNode> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i : to_delete) set.add(i);
        
        helper(root, true, set, ans);
        
        return ans;
    }
    
    private TreeNode helper(TreeNode root, boolean isRoot, Set<Integer> set, List<TreeNode> list) {
        if (root == null) return null;
        if (set.isEmpty()) return root;
        
        boolean deleted = set.contains(root.val);
        if (isRoot && !deleted) list.add(root);
        
        root.left = helper(root.left, deleted, set, list);
        root.right = helper(root.right, deleted, set, list);
        
        return deleted ? null : root;
    }
}