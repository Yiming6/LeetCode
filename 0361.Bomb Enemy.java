class Solution {
    /*
     Traversal the graph, everytime there is '0' start to check its row and column until 
     margins or wall. Count the number of enemy.
     O(mn(m + n)).
    */
    
    int[][] dirs;
    public int maxKilledEnemies(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        
        dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        int ans = 0, m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') ans = Math.max(ans, dfs(grid, i, j));
            }
        }
        
        return ans;
    }
    
    private int dfs(char[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length, cnt = 0;
        
        for (int[] dir : dirs) {
            int y = i, x = j;
            while (y + dir[0] >= 0 && y + dir[0] < m && x + dir[1] >= 0 && x + dir[1] < n && grid[y + dir[0]][x + dir[1]] != 'W') {
                y += dir[0];
                x += dir[1];
                
                if (grid[y][x] == 'E') cnt++;
            }
        }
        
        return cnt;
    }
}