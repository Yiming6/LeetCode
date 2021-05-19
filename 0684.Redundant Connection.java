class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        if (edges.length == 0 || edges[0].length == 0) return new int[2];
        
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        
        for (int[] edge : edges) {
            if (!graph.containsKey(edge[0])) graph.put(edge[0], new HashSet<>());
            if (!graph.containsKey(edge[1])) graph.put(edge[1], new HashSet<>());
            
            if (hasCycle(graph, edge[0], edge[1], -1)) return edge;
            
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        return new int[2];
    }
    
    private boolean hasCycle(Map<Integer, Set<Integer>> graph, int curr, int target, int pre) {
        if (curr == target) return true;
        
        for (int next : graph.get(curr)) {
            if (next == pre) continue;
            if (hasCycle(graph, next, target, curr)) return true;
        }
        
        return false;
    } 
}