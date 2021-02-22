class Solution {
    /*
        dfs. Find a target in graph.
    */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze.length == 0 || maze[0].length == 0) return false;
        
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        
        return dfs(maze, start, destination, visited);
    }
    
    private boolean dfs(int[][] maze, int[] curr, int[] destination, boolean[][] visited) {
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int m = maze.length, n = maze[0].length, y = curr[0], x = curr[1];
        
        visited[y][x] = true;
        
        for (int[] dir : dirs) {
            y = curr[0]; x = curr[1];
            while (y + dir[0] >= 0 && y + dir[0] < m && x + dir[1] >= 0 && x + dir[1] < n && maze[y + dir[0]][x + dir[1]] != 1) {
                y += dir[0];
                x += dir[1];
            }
            
            if (y == destination[0] && x == destination[1]) return true;
            if (visited[y][x]) continue;
            
            if (dfs(maze, new int[]{y, x}, destination, visited)) return true;
        }
        
        return false;
    }
}