class Solution {
    /*
        dfs, finding cycle in directed graph.
        A graph is a valid tree if all nodes are connected and no cycle.
        So we use dfs to traversal the graph from any node and return false as long as
        we found cycle. In the end we check whether all nodes have been visited.
        O(E + V).
    */
    public boolean validTree(int n, int[][] edges) {
        if (n == 0) return true;
        
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        
        if (hasCycle(graph, visited, 0, -1)) return false;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) return false;
        }
        
        return true;
    }
    
    private boolean hasCycle(List<Integer>[] graph, boolean[] visited, int curr, int pre) {
        if (visited[curr]) return true;
        
        visited[curr] = true;
        
        for (int next : graph[curr]) {
            if (next == pre) continue;
            if (hasCycle(graph, visited, next, curr)) return true;
        }
        
        return false;
    }
}