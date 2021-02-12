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
    
    int i = 0;
    List<Integer> ans = new ArrayList<>();
    
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        return dfs(root, voyage) ? ans : Arrays.asList(-1);
    }
    
    private boolean dfs(TreeNode root, int[] voyage) {
        if (root == null) return true;
        
        if (root.val != voyage[i]) return false;
        
        i++;
        
        if (root.left != null && root.left.val != voyage[i]) {
            ans.add(root.val);
            return dfs(root.right, voyage) && dfs(root.left, voyage);
        }
        
        return dfs(root.left, voyage) && dfs(root.right, voyage);
    }
}