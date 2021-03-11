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
        Level order traversal and indexing. 
        Set the coordinate of root is 0 and every its left child is coor - 1, right is
        coor + 1. And a tree map to record result, key is coor ,value is the list that 
        node in this coor. The reason why using treemap is the final result must be sorted
        from left to right.
        O(n).
    */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Pair<Integer, TreeNode>> queue = new LinkedList<>();
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        
        queue.add(new Pair<>(0, root));
        
        while(!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                Pair<Integer, TreeNode> curr = queue.poll();
                int coor = curr.getKey();
                TreeNode node = curr.getValue();
                
                if (!map.containsKey(coor)) map.put(coor, new ArrayList<>());
                map.get(coor).add(node.val);
                
                if (node.left != null) queue.add(new Pair<>(coor - 1, node.left));
                if (node.right != null) queue.add(new Pair<>(coor + 1, node.right));
            }
        }
        
        for (int coor : map.keySet()) ans.add(map.get(coor));
        
        return ans;
    }
}