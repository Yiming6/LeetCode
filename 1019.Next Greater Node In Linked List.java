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
class Solution {
    /*
        Linked List and stack. First we need a map to store the index to certain node.
        Then use a stack to push nodes. If current nodes no greater than peek, push this 
        node into stack, because this is not the next greater node of current one and 
        this one need to wait to be handled. If we found the node that greater than peek
        one we need to pop all top nodes until the peek one greater than current one, because
        the next greater node of these nodes are all current value. Finally, set all 
        leftover nodes in stack to 0, because they don't have next greater value.
        O(n).
    */
    public int[] nextLargerNodes(ListNode head) {
        if (head == null) return new int[0];
        
        Map<ListNode, Integer> map = new HashMap<>();
        Stack<ListNode> stack = new Stack<>();
    
        ListNode curr = head;
        int index = 0;
        while (curr != null) {
            map.put(curr, index++);
            curr = curr.next;
        }
        
        int[] ans = new int[map.keySet().size()];
        curr = head;
        while (curr != null) {
            while (!stack.isEmpty() && curr.val > stack.peek().val) {
                ListNode node = stack.pop();
                ans[map.get(node)] = curr.val;
            }
            
            stack.push(curr);
            
            curr = curr.next;
        }
        
        while (!stack.isEmpty()) ans[map.get(stack.pop())] = 0;
        
        return ans;
    }
}