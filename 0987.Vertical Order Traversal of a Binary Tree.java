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
        Level order traversal + indexing tree nodes.
        Note that values in the same position should be sorted.
    */
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        
        // level order traversal
        List<List<Pair<TreeNode, Integer>>> tree = new ArrayList<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        
        queue.add(new Pair<>(root, 0));
        while (!queue.isEmpty()) {
            List<Pair<TreeNode, Integer>> list = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                Pair<TreeNode, Integer> curr = queue.poll();
                TreeNode node = curr.getKey();
                int coor = curr.getValue();
                
                list.add(curr);
                if (node.left != null) queue.add(new Pair<>(node.left, coor - 1));
                if (node.right != null) queue.add(new Pair<>(node.right, coor + 1));
            }
            tree.add(list);
        }
        
        // build answer
        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (List<Pair<TreeNode, Integer>> level : tree) {
            // handle the case that same position but different value
            Map<Integer, List<Integer>> sorted = new HashMap<>();
            for (Pair<TreeNode, Integer> curr : level) {
                TreeNode node = curr.getKey();
                int coor = curr.getValue();
                
                if (!sorted.containsKey(coor)) sorted.put(coor, new ArrayList<>());
                sorted.get(coor).add(node.val);
            }
            for (int key : sorted.keySet()) {
                Collections.sort(sorted.get(key));
                for (int val : sorted.get(key)) {
                    if (!map.containsKey(key)) map.put(key, new ArrayList<>());
                    map.get(key).add(val);
                }
            }
        }
        
        for (int coor : map.keySet()) ans.add(map.get(coor));
        
        return ans;
    }
}