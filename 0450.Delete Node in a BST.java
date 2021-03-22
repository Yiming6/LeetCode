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
        According to the property of BST, if key is larger or smaller than root's value,
        let left or right subtree to handle it. If root is the target, we need to find the
        most left node in right subtree and exchange its value and delete node in right
        subtree.
        O(n).
    */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        
        if (root.val < key) root.right = deleteNode(root.right, key);
        else if (root.val > key) root.left = deleteNode(root.left, key);
        else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            
            TreeNode curr = root.right;
            while (curr.left != null) curr = curr.left;
            
            root.val = curr.val;
            root.right = deleteNode(root.right, curr.val);
        }
        
        return root;
    }
}