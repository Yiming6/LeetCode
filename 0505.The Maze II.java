class Solution {
    
    int[][] dirs;
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (maze.length == 0 || maze[0].length == 0) return 0;
        
        dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = maze.length, n = maze[0].length;
        
        int[][] dists = new int[m][n];
        for (int[] dist : dists) Arrays.fill(dist, Integer.MAX_VALUE);
        
        helper(maze, dists, start, destination, 0);
        
        return dists[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dists[destination[0]][destination[1]];
    }
    
    private void helper(int[][] maze, int[][] dists, int[] start, int[] destination, int dist) {
        if (start[0] == destination[0] && start[1] == destination[1]) return;
        
        int m = maze.length, n = maze[0].length;
        
        for (int[] dir : dirs) {
            int y = start[0], x = start[1], len = dist;
            
            while (y + dir[0] >= 0 && y + dir[0] < m && x + dir[1] >= 0 && x + dir[1] < n && maze[y + dir[0]][x + dir[1]] == 0) {
                y += dir[0];
                x += dir[1];
                len++;
            }
            
            if (len < dists[y][x]) {
                dists[y][x] = len;
                helper(maze, dists, new int[]{y, x}, destination, len);
            }
        }
    }
}