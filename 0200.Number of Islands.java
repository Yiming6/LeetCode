class Solution {
    /*
        dfs traversal graph. if we found a land and unvisited, start dfs from this land.
        Everytime traversal, mark all adjacent land to visited.
        O(nm).
    */
    
    int[][] dirs;
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        
        dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int m = grid.length, n = grid[0].length, ans = 0;
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    ans++;
                    dfs(grid, visited, i, j);
                }
            }
        }
        
        return ans;
    }
    
    private void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        int m = grid.length, n = grid[0].length;
        
        visited[i][j] = true;
        
        for (int[] dir : dirs) {
            int y = i + dir[0], x = j + dir[1];
            if (y >= 0 && y < m && x >= 0 && x < n && !visited[y][x] && grid[y][x] == '1')
                dfs(grid, visited, y, x);
        }
    }
}