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
        Splitting the binary to two parts. Using a map to record sum of each subtree.
        Bottom to top.
    */
    public int maxProduct(TreeNode root) {
        if (root == null) return 0;
        
        Map<TreeNode, Long> map = new HashMap<>();
        long sum = helper(root, map);
        
        long ans = 0;
        for (TreeNode curr : map.keySet()) {
            long part = map.get(curr);
            ans = Math.max(ans, part * (sum - part));
        }
        
        return (int) (ans % (Math.pow(10, 9) + 7));
    }
    
    private long helper(TreeNode root, Map<TreeNode, Long> map) {
        if (root == null) return 0;
        
        long sum = helper(root.left, map) + helper(root.right, map) + root.val;
        map.put(root, sum);
        
        return sum;
    }
}