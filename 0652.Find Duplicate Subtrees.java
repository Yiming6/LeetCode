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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) return new ArrayList<>();
        
        Map<String, Integer> map = new HashMap<>();
        List<TreeNode> ans = new ArrayList<>();
        
        helper(root, map, ans);
        
        return ans;
    }
    
    private String helper(TreeNode root, Map<String, Integer> map, List<TreeNode> list) {
        if (root == null) return new String();
        
        String left = helper(root.left, map, list), right = helper(root.right, map, list);
                
        if (right.length() != 0) {
            left = "(" + left + ")";
            right = "(" + right + ")";
        } else if (left.length() != 0) left = "(" + left + ")";
        
        String current = String.valueOf(root.val) + left + right;
        
        map.put(current, map.getOrDefault(current, 0) + 1);
        
        if (map.get(current) == 2) list.add(root);
        
        return current;
    }
}