/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    /*
        Level Order Traversal. Children nodes are in the list instead of left and right.
        O(n).
    */
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return new ArrayList<>();
        
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        
        queue.add(root);
        
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                Node curr = queue.poll();
                list.add(curr.val);
                
                for (Node child : curr.children) queue.add(child);
            }
            ans.add(list);
        }
        
        return ans;
    }
}