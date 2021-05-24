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
class CBTInserter {
    List<TreeNode> list;
    public CBTInserter(TreeNode root) {
        if (root == null) return;
        
        list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            
            list.add(curr);
            
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
    }
    
    public int insert(int v) {
        TreeNode curr = new TreeNode(v);
        
        list.add(curr);
        
        int position = list.size();
        
        TreeNode parent = list.get(position / 2 - 1);
        
        if (position % 2 == 0) parent.left = curr;
        else parent.right = curr;
        
        return parent.val;
    }
    
    public TreeNode get_root() {
        return list.get(0);
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(v);
 * TreeNode param_2 = obj.get_root();
 */