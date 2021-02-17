/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
        Recursively compare binary and linked list. Similar to identical binary trees.
        When we found a TreeNode that same to head of linkedlist, we need to check rest of 
        nodes of linkedlist and tree. Otherwise, check head with downword treenodes.
        Notice the base case. Top to bottom.
    */
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return head == null;
        
        boolean candi = false;
        if (head.val == root.val) candi = helper(head, root);
        
        return candi || isSubPath(head, root.left) || isSubPath(head, root.right);
    }
    
    private boolean helper(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return head == null;
        
        if (root.val != head.val) return false;
        return helper(head.next, root.left) || helper(head.next, root.right);
    }
}