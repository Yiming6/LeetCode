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
class FindElements {
    /*
        Traversal binary tree and set values. Top to bottom.
        Ues a set to record values in the tree.
    */
    
    Set<Integer> set;

    public FindElements(TreeNode root) {
        set = new HashSet<>();
        helper(root, 0);
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
    
    private void helper(TreeNode root, int val) {
        if (root == null) return;
        
        root.val = val;
        set.add(val);
        
        if (root.left != null) helper(root.left, 2 * val + 1);
        if (root.right != null) helper(root.right, 2 * val + 2);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */