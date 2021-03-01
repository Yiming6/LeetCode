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
        Construct a tree from linked list. Top to bottom.
        Two pointers. one is twice faster than the other one to pinpoint the mid node.
    */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        
        ListNode pre = new ListNode();
        pre.next = head;
        
        ListNode curr = head;
        ListNode end = head;
        
        while (end != null && end.next != null) {
            curr = curr.next;
            end = end.next.next;
            pre = pre.next;
        }
        
        TreeNode root = new TreeNode(curr.val);
        
        pre.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(curr.next);
        
        return root;
    }
}