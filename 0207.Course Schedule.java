class Solution {
    /*
        Topological sorting. Implemented by dfs.
        Set states that -1 is processing, 0 is unvisited, and 1 is processed.
        First build graph as formation of adjacent lists.
        Then start to traversal from each node, as long it is not being visited.
        In the beginning, when we check one node, set it as -1, and go to its all outgoing
        directions. We cannot say whether this node is on a cycle or not before we checking 
        all possible paths starting from this node. During the traversal, if we found a 
        processing node, this means there is a cycle. After we traversaled all nodes along 
        this route, we can mark current route to processed. And go to next node.
        O(E + V).
    */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || numCourses == 1) return true;
        
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) graph[i] = new ArrayList<>();
        
        for (int[] prerequisite : prerequisites) graph[prerequisite[1]].add(prerequisite[0]);
        
        // -1: processing, 0:unvisited, 1:processed
        int[] visited = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && hasCycle(graph, visited, i)) return false; 
        }
        
        return true;
    }
    
    private boolean hasCycle(List<Integer>[] graph, int[] visited, int curr) {
        if (visited[curr] == -1) return true;
        if (visited[curr] == 1) return false;
        
        visited[curr] = -1;
        
        for (int next : graph[curr]) {
            if (hasCycle(graph, visited, next)) return true;
        }
        
        visited[curr] = 1;
        
        return false;
    }
}