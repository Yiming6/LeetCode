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
        Level order traversal. Check completeness of last level and others separately.
    */
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return true;
        
        // level order traversal
        List<List<TreeNode>> tree = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        
        while (!queue.isEmpty()) {
            List<TreeNode> list = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode curr = queue.poll();
                list.add(curr);
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
            tree.add(list);
        }
        
        // check the completeness except the last level
        for (int i = 0; i < tree.size() - 1; i++) {
            if (tree.get(i).size() != Math.pow(2, i)) return false;
        }
        
        // check the completeness of the last level
        List<TreeNode> list = tree.get(tree.size() - 2);
        int index = list.size() - 1;
        while (list.get(index).right == null && list.get(index).left == null) index--;
        if (list.get(index).left == null && list.get(index).right != null) return false;
        
        for (int i = index - 1; i >= 0; i--) {
            if (list.get(i).left == null || list.get(i).right == null) return false;
        }
        
        return true;
    }
}