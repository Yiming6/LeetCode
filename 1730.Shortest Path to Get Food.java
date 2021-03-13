class Solution {
    /*
        dfs traversal the graph from '*' and update the length to each position 
        when current length is less than existed length. Finally return the minimum
        value of all food points. But TLE.
        bfs, similar to level order traversal.
        O(mn).
    */
    
//    int[][] dirs;
    public int getFood(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return -1;
        
//        dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
//         int m = grid.length, n = grid[0].length, y = 0, x = 0;
//        Set<Pair<Integer, Integer>> set = new HashSet<>();
        
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (grid[i][j] == '*') {y = i; x = j;}
//                if (grid[i][j] == '#') set.add(new Pair<>(i, j));
//             }
//         }
        
//         int[][] dists = new int[m][n];
//         for (int[] dist : dists) Arrays.fill(dist, Integer.MAX_VALUE);
//         dists[y][x] = 0;
        
//         dfs(grid, dists, y, x, 0);
        
//         int ans = Integer.MAX_VALUE;
//         for (Pair<Integer, Integer> p : set) ans = Math.min(ans, dists[p.getKey()][p.getValue()]);
        
//         return ans == Integer.MAX_VALUE ? -1 : ans;
        
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '*') {queue.add(new int[]{i, j}); break;}
            }
        }
        
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // boolean[][] visited = new boolean[m][n];
        
        int ans = 0;
        while (!queue.isEmpty()) {
            ans++;
            
            for (int i = queue.size(); i > 0; i--) {
                int[] curr = queue.poll();
                
                // visited[curr[0]][curr[1]] = true;
            
                for (int[] dir : dirs) {
                    int y = curr[0] + dir[0], x = curr[1] + dir[1];
                    if (y >= 0 && y < m && x >= 0 && x < n && grid[y][x] != 'X') {
                        if (grid[y][x] == '#') return ans;
                        queue.add(new int[]{y, x});
                        grid[y][x] = 'X';
                    }
                }
            }
        }
        
        return -1;
    }
//     private void dfs(char[][] grid, int[][] dists, int y, int x, int length) {
//         int m = grid.length, n = grid[0].length;
        
//         for (int[] dir : dirs) {
//             int i = y + dir[0], j = x + dir[1];
            
//             if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] != 'X' && dists[i][j] > length + 1) {
//                 dists[i][j] = length + 1;
//                 dfs(grid, dists, i, j, length + 1);
//             }
//         }
//     }
}