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
        Level order traversal with parents map.
    */
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        
        List<Set<Integer>> tree = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            Set<Integer> set = new HashSet<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode curr = queue.poll();
                set.add(curr.val);
                
                if (curr.left != null) {
                    queue.add(curr.left);
                    map.put(curr.left.val, curr.val);
                }
                
                if (curr.right != null) {
                    queue.add(curr.right);
                    map.put(curr.right.val, curr.val);
                }
            }
            tree.add(set);
        }
        
        for (Set<Integer> set : tree) {
            if (set.contains(x) && set.contains(y)) return map.get(x) != map.get(y);
        }
        
        return false;
    }
}