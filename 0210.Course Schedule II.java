class Solution {
    /*
        Topological sorting, implemented by dfs. After one node's all paths are being 
        detected and no cycle, we can add this node to list. When building the graph, because 
        the directions is the same as orders of courses, the order that we added node
        in list is opposited. 
        O(E + V).
    */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return new int[0];
        
        List<Integer> list = new ArrayList<>();
        List<Integer>[] graph = new ArrayList[numCourses];
        
        for (int i = 0; i < numCourses; i++) graph[i] = new ArrayList<>();
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[1]].add(prerequisite[0]);
        }
        
        // 0: unvisited, -1: processing, 1: processed
        int[] visited = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(graph, visited, i, list)) return new int[0];
        }
        
        Collections.reverse(list);
        int[] ans = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) ans[i] = list.get(i);
        
        return ans;
    }
    
    private boolean hasCycle(List<Integer>[] graph, int[] visited, int curr, List<Integer> list) {
        if (visited[curr] != 0) return visited[curr] == -1;
        
        visited[curr] = -1;
        
        for (int next : graph[curr]) {
            if (hasCycle(graph, visited, next, list)) return true;
        }
        
        visited[curr] = 1;
        list.add(curr);

        return false;
    }
}