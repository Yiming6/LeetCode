class Solution {
    /*
        dfs in graph to find the shortest path. With the idea of dp.
        But if we try every path and compare the final distance at destination, the result
        will be TLE.
        We can use an integer array to substitute the visited array to record the shortest
        distance to current position. If the new path to current position is larger than 
        previous paths, we don't need to continue, otherwise update current distance to 
        lesser number.
    */
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (maze.length == 0 || maze[0].length == 0) return 0;
        if (start[0] == destination[0] && start[1] == destination[1]) return 0;
        
        int m = maze.length, n = maze[0].length;
        int[][] dists = new int[m][n];
        for (int[] dist : dists) Arrays.fill(dist, Integer.MAX_VALUE);
        
        dists[start[0]][start[1]] = 0;
        
        dfs(maze, dists, start, destination);
        
        return dists[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dists[destination[0]][destination[1]];
    }
    
    private void dfs(int[][] maze, int[][] dists, int[] curr, int[] destination) {
        if (curr[0] == destination[0] && curr[1] == destination[1]) return;
        
        int m = maze.length, n = maze[0].length;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        for (int[] dir : dirs) {
            int i = curr[0], j = curr[1], dist = dists[curr[0]][curr[1]];
            while (i + dir[0] >= 0 && i + dir[0] < m && j + dir[1] >= 0 && j + dir[1] < n && maze[i + dir[0]][j + dir[1]] == 0) {
                i += dir[0];
                j += dir[1];
                dist++;
            }
            
            if (dists[i][j] > dist) {
                dists[i][j] = dist;
                dfs(maze, dists, new int[]{i, j}, destination);
            }
        }
    }
}