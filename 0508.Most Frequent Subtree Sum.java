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
    
    int max;
    Map<Integer, Integer> map;
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[0];
        
        max = 1;
        map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        helper(root, list);
        
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) ans[i] = list.get(i);
        
        return ans;
    }
    
    private int helper(TreeNode root, List<Integer> list) {
        if (root == null) return 0;
        
        int left = helper(root.left, list), right = helper(root.right, list);
        
        int sum = left + right + root.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        
        if (map.get(sum) >= max) {
            if (map.get(sum) > max) list.clear();
            list.add(sum);
            max = map.get(sum);
        }
        
        return sum;
    }
}