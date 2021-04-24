/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node inorderSuccessor(Node node) {
        if (node == null) return null;
        
        if (node.right != null) {
            node = node.right;
            while (node.left != null) node = node.left;
            return node;
        }
        
        while (node != null) {
            Node curr = node.parent;
            if (curr == null) return null;
            if (node.equals(curr.left)) return curr;
            node = curr;
        }
        
        return null;
    }
}