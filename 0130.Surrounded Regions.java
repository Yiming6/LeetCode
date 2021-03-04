class Solution {
    /*
        dfs, traversal graph. When we found a 'O', check whether this region is surrounded,
        more specificly, checking whether this region reached margins. If it is, flip 
        this region.
        Note that return after finishing traversalling one region. 
        O(mn).
    */
    
    int[][] dirs;
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        
        dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    if (surrounded(board, visited, i, j)) flip(board, i, j);
                }
            }
        }
    }
    
    private boolean surrounded(char[][] board, boolean[][] visited, int i, int j) {
        int m = board.length, n = board[0].length;
        boolean surrounded = true;
        
        visited[i][j] = true;
        
        for (int[] dir : dirs) {
            int y = i + dir[0], x = j + dir[1];
            
            if (y < 0 || y >= m || x < 0 || x >= n) {surrounded = false; continue;}
            if (board[y][x] == 'O' && !visited[y][x]) {
                if (!surrounded(board, visited, y, x)) surrounded = false;
            }
        }
        
        return surrounded;
    }
    
    private void flip(char[][] board, int i, int j) {
        int m = board.length, n = board[0].length;
        
        board[i][j] = 'X';
        
        for (int[] dir : dirs) {
            int y = i + dir[0], x = j + dir[1];
            
            if (y >= 0 && y < m && x >= 0 && x < n && board[y][x] == 'O') flip(board, y, x);
        }
    }
}