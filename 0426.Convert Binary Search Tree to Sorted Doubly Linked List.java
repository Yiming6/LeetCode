/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    /*
        Due to the property of Binary Search Tree, inorder traversal is sorted. We build
        a list of its inorder traversal and then make it double linked list.
        O(n).
    */
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        
        List<Node> list = new ArrayList<>();
        helper(root, list);
        
        if (list.size() == 1) {
            Node head = list.get(0);
            head.left = head;
            head.right = head;
            return head;
        }
        
        Node head = list.get(0), tail = list.get(list.size() - 1);
        for (int i = 1; i < list.size() - 1; i++) {
            list.get(i).left = list.get(i - 1);
            list.get(i).right = list.get(i + 1);
        }
        
        head.left = tail;
        head.right = list.get(1);
        
        tail.left = list.get(list.size() - 2);
        tail.right = head;
        
        return head;
    }
    
    private void helper(Node root, List<Node> list) {
        if (root == null) return;
        
        helper(root.left, list);
        list.add(root);
        helper(root.right, list);
    }
}