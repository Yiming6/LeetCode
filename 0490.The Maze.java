class Solution {
    /*
        dfs. Find a target in graph.
    */
    
    int[][] dirs;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze.length == 0 || maze[0].length == 0) return false;
        
        dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        
        return dfs(maze, visited, start, destination);
    }
    
    private boolean dfs(int[][] maze, boolean[][] visited, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        
        visited[start[0]][start[1]] = true;
        
        for (int[] dir : dirs) {
            int y = start[0], x = start[1];
            
            while (y + dir[0] >= 0 && y + dir[0] < m && x + dir[1] >= 0 && x + dir[1] < n && maze[y + dir[0]][x + dir[1]] == 0) {
                y += dir[0];
                x += dir[1];
            }
            
            if (destination[0] == y && destination[1] == x) return true;
            if (visited[y][x]) continue;
            
            if (dfs(maze, visited, new int[]{y, x}, destination)) return true;
        }
        
        return false;
    }
}