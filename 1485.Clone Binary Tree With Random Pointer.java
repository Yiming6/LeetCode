/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */

class Solution {
    public NodeCopy copyRandomBinaryTree(Node root) {
        if (root == null) return null;
        
        Map<Node, NodeCopy> map = new HashMap<>();
        createNode(root, map);
        
        for (Node curr : map.keySet()) {
            NodeCopy copy = map.get(curr);
            copy.left = map.get(curr.left);
            copy.right = map.get(curr.right);
            copy.random = map.get(curr.random);
        }
        
        return map.get(root);
    }
    
    private void createNode(Node root, Map<Node, NodeCopy> map) {
        if (root == null) return;
        
        map.put(root, new NodeCopy(root.val));
        createNode(root.left, map);
        createNode(root.right, map);
    }
}