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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        
        List<List<Pair<TreeNode, Integer>>> tree = new ArrayList<>();
        
        queue.add(new Pair(root, 0));
        
        while (!queue.isEmpty()) {
            List<Pair<TreeNode, Integer>> list = new ArrayList<>();
            
            for (int i = queue.size(); i > 0; i--) {
                Pair<TreeNode, Integer> curr = queue.poll();
                
                TreeNode node = curr.getKey();
                int coor = curr.getValue();
                
                list.add(new Pair(node, coor));
                
                if (node.left != null) queue.add(new Pair(node.left, coor - 1));
                if (node.right != null) queue.add(new Pair(node.right, coor + 1));
            }
            
            tree.add(list);
        }
        
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        
        for (List<Pair<TreeNode, Integer>> level : tree) {
            Map<Integer, List<Integer>> levelMap = new HashMap<>();
            
            for (Pair<TreeNode, Integer> pair : level) {
                TreeNode node = pair.getKey();
                int coor = pair.getValue();
                
                if (!levelMap.containsKey(coor)) levelMap.put(coor, new ArrayList<>());
                levelMap.get(coor).add(node.val);
            }
            
            for (int coor : levelMap.keySet()) {
                if (levelMap.get(coor).size() > 1) 
                    Collections.sort(levelMap.get(coor));
                
                if (!map.containsKey(coor)) map.put(coor, new ArrayList<>());
                map.get(coor).addAll(levelMap.get(coor));
            }
        }
        
        for (int coor : map.keySet()) ans.add(map.get(coor));
        
        return ans;
    }
}