/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    /*
        HashMap. Created all copys of each node and created neighbors coresponding to
        the relationship to original graph.
        O(n);
    */
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        
        Map<Node, Node> map = new HashMap<>();
        Set<Node> set = new HashSet<>();
        
        helper(node, map, set);
        
        for (Node curr : map.keySet()) {
            Node copy = map.get(curr);
            List<Node> list = new ArrayList<>();
            
            for (Node neighbor : curr.neighbors) list.add(map.get(neighbor));
            
            copy.neighbors = list;
        }
        
        return map.get(node);
    }
    
    private void helper(Node node, Map<Node, Node> map, Set<Node> set) {
        if (node == null) return;
        
        map.put(node, new Node(node.val));
        set.add(node);
        
        for (Node neighbor : node.neighbors) {
            if (!set.contains(neighbor)) helper(neighbor, map, set);
        }
    }
}