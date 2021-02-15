class Solution {
    /*
        dfs. Find the longest route in tree.
    */
    
    int ans;
    
    public int treeDiameter(int[][] edges) {
        if (edges.length == 0 || edges[0].length == 0) return 0;
        
        int n = edges.length + 1;
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        ans = 0;
        dfs(graph, 0, -1);
        
        return ans;
    }
    
    private int dfs(List<Integer>[] graph, int curr, int pre) {
        int max1 = 0, max2 = 0;
        
        for (int next : graph[curr]) {
            if (next == pre) continue;
            
            int depth = dfs(graph, next, curr);
            if (depth > max1) {
                max2 = max1;
                max1 = depth;
            } else if (depth > max2) max2 = depth;
        }
        
        ans = Math.max(ans, max1 + max2);
        return max1 + 1;
    }
}