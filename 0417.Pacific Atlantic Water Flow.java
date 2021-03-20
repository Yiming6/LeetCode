class Solution {
    /*
        dfs. traversal the graph.
        two boolean graphs and starting traversal from top, left and bottom, right.
        Mark position that reached as visited. Then return the points that can be
        reached in two graphs.
        O(mn).
    */
    
    int[][] dirs;
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();
        
        dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = matrix.length, n = matrix[0].length;
        
        boolean[][] pacific = new boolean[m][n], atlantic = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            dfs(matrix, pacific, i, 0);
            dfs(matrix, atlantic, i, n - 1);
        }
        
        for (int i = 0; i < n; i++) {
            dfs(matrix, pacific, 0, i);
            dfs(matrix, atlantic, m - 1, i);
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j])
                    ans.add(Arrays.asList(new Integer[]{i, j}));
            }
        }
        
        return ans;
    }
    
    private void dfs(int[][] matrix, boolean[][] visited, int i, int j) {
        int m = matrix.length, n = matrix[0].length;
        
        visited[i][j] = true;
        
        for (int[] dir : dirs) {
            int y = i + dir[0], x = j + dir[1];
            if (y >= 0 && y < m && x >= 0 && x < n && !visited[y][x] && matrix[y][x] >= matrix[i][j])
                dfs(matrix, visited, y, x);
        }
    }
}