class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return new int[0];
        
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) graph[i] = new ArrayList<>();
        
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[1]].add(prerequisite[0]);
        }
        
        List<Integer> list = new ArrayList<>();
        // 0: unvisited, 1: processed, -1: processing
        int[] visited = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, visited, i, list)) return new int[0];
        }
        
        Collections.reverse(list);
        
        int[] ans = new int[numCourses];
        for (int i = 0; i < numCourses; i++) ans[i] = list.get(i);
        
        return ans;
    }
    
    private boolean dfs(List<Integer>[] graph, int[] visited, int curr, List<Integer> list) {
        if (visited[curr] != 0) return visited[curr] == 1;
        
        visited[curr] = -1;
        
        for (int next : graph[curr]) {
            if (!dfs(graph, visited, next, list)) return false;
        }
        
        list.add(curr);
        visited[curr] = 1;
        
        return true;
    }
}