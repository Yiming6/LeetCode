class Solution {
    /*
        Tree to graph. Postorder traversal of graph. Bottom to top.
        Similar to delete leaf node. Delete node that is leaf (one edge) and without apple.
        Then count the edges that left in the graph.
    */
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        if (n == 0) return 0;
        
        // build graph
        Set<Integer>[] graph = new HashSet[n];
        for (int i = 0; i < n; i++) graph[i] = new HashSet<>();
        
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        dfs(graph, hasApple, 0, -1);
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += graph[i].size();
        }
        
        return ans;
    }
    
    private void dfs(Set<Integer>[] graph, List<Boolean> hasApple, int curr, int pre) {
        // traversal to children
        Set<Integer> children = new HashSet<>(graph[curr]);
        for (int next : children) {
            if (next == pre) continue;
            dfs(graph, hasApple, next, curr);
        }
        
        // deal with current node
        // leaf node and no apple
        if (curr != 0 && graph[curr].size() == 1 && !hasApple.get(curr)) {
            // delete this edge
            graph[curr].remove(pre);
            graph[pre].remove(curr);
        }
    }
}