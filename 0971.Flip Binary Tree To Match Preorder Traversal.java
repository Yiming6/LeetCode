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
    int i;
    List<Integer> ans;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        if (root == null || voyage.length == 0) return new ArrayList<>();
        
        i = 0;
        ans = new ArrayList<>();
        
        return helper(root, voyage) ? ans : Arrays.asList(-1);
    }
    
    private boolean helper(TreeNode root, int[] voyage) {
        if (root == null) return true;
        
        if (root.val != voyage[i]) return false;
        
        i++;
        
        if (root.left != null && root.left.val != voyage[i]) {
            ans.add(root.val);
            return helper(root.right, voyage) && helper(root.left, voyage);
        }
        
        return helper(root.left, voyage) && helper(root.right, voyage);
    }
}