class Solution {
    /*
        dfs traversal the graph. bfs is also working.
        In the beginning, set all 1 into Integer.max value. Start traversal from 0 and 
        initial distance is 0. If next grid is 0 continue.
        If next grid is not 0, check its current number and compare with distance from 
        starter. If current distance is smaller, update it and continue traversalling. 
        Otherwise, stop searching.
        O(kmn) k is the number of 0.
    */
    
    int[][] dirs;
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new int[0][0];
        
        dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = matrix.length, n = matrix[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) 
                if (matrix[i][j] == 1) matrix[i][j] = Integer.MAX_VALUE;
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) continue;
                
                dfs(matrix, i, j, 0);
            }
        }
        
        return matrix;
    }
    
    private void dfs(int[][] matrix, int i, int j, int dis) {
        int m = matrix.length, n = matrix[0].length;
                
        for (int[] dir : dirs) {
            int y = i + dir[0], x = j + dir[1];
            if (y >= 0 && y < m && x >= 0 && x < n && matrix[y][x] > dis + 1) {
                matrix[y][x] = dis + 1;
                dfs(matrix, y, x, dis + 1);
            }
        }
    }
}