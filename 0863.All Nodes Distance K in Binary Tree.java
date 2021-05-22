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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null || target == null) return new ArrayList<>();
        
        List<Integer> ans = new ArrayList<>();
        
        if (k == 0) {
            ans.add(target.val);
            return ans;
        }
        
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        Set<TreeNode> visited = new HashSet<>();
        
        buildGraph(root, null, parents);
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
                
        while (k >= 0) {
            for (int i = queue.size(); i > 0; i--) {
                TreeNode curr = queue.poll();
                
                if (k == 0) ans.add(curr.val);
                
                visited.add(curr);
                
                if (parents.get(curr) != null && !visited.contains(parents.get(curr))) queue.add(parents.get(curr));
                if (curr.left != null && !visited.contains(curr.left)) queue.add(curr.left);
                if (curr.right != null && !visited.contains(curr.right)) queue.add(curr.right);
            }
            
            k--;
        }
        
        return ans;
    }
    
    private void buildGraph(TreeNode root, TreeNode pre, Map<TreeNode, TreeNode> parents) {
        if (root == null) return;
        
        parents.put(root, pre);
        
        buildGraph(root.left, root, parents);
        buildGraph(root.right, root, parents);
    }
}