class Solution {
    /*
        dfs in graph. From source to destination. Return false if we found any cycle.
        When we reach a node that has no any outgoing edge, check whether it is destination.
        Graph postorder traversal, topological sorting.
        Find cycle in the directed graph.
    */
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        if (n == 0) return false;
        
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }
        
        if (graph[destination].size() != 0) return false;
        
        // 0: unvisited, 1: visiting, 2: visited
        int[] visited = new int[n];
        
        return dfs(graph, visited, source, destination);
    }
    
    private boolean dfs(List<Integer>[] graph, int[] visited, int curr, int destination) {
        if (visited[curr] != 0) return visited[curr] == 2;
        
        if (graph[curr].size() == 0) return curr == destination;
        
        visited[curr] = 1; // visiting
        
        for (int next : graph[curr]) {
           if (!dfs(graph, visited, next, destination)) return false;
        }
        
        visited[curr] = 2; // visited, all path has been detected
        
        return true;
    }
}