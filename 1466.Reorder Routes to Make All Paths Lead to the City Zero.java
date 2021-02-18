class Solution {
    /*
        dfs. Traversal graph.
    */
    
    int ans;
    public int minReorder(int n, int[][] connections) {
        if (n == 0) return 0;
        
        Set<Integer>[] graph = new HashSet[n];
        Set<Integer>[] original = new HashSet[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new HashSet<>();
            original[i] = new HashSet<>();
        }
        
        for (int[] connection : connections) {
            graph[connection[0]].add(connection[1]);
            graph[connection[1]].add(connection[0]);
            original[connection[0]].add(connection[1]);
        }
        
        dfs(graph, original, 0, -1);
        
        return ans;
    }
    
    private void dfs(Set<Integer>[] graph, Set<Integer>[] original, int curr, int pre) {
        for (int next : graph[curr]) {
            if (next == pre) continue;
            
            if (original[curr].contains(next)) ans++;
            dfs(graph, original, next, curr);
        }
    }
}