class Solution {
    /*
        build graph, and dfs for each unvisited node. Mark all connected node visited.
        The answer is the time that we did dfs.
        O(E + V).
    */
    public int countComponents(int n, int[][] edges) {
        if (n == 0) return 0;
        
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        int ans = 0;
        
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            
            ans++;
            dfs(graph, visited, i);
        }
        
        return ans;
    }
    
    private void dfs(List<Integer>[] graph, boolean[] visited, int curr) {
        visited[curr] = true;
        
        for (int next : graph[curr]) {
            if (!visited[next]) dfs(graph, visited, next);
        }
    }
}