class Solution {
    public int findCircleNum(int[][] isConnected) {
        if (isConnected.length == 0 || isConnected[0].length == 0) return 0;
        
        int n = isConnected.length;
        List<Integer>[] graph = new ArrayList[n];
        
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                
                if (isConnected[i][j] == 1) graph[i].add(j);
            }
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