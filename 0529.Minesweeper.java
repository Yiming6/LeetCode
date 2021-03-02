class Solution {
    /*
        Traversal Graph.
    */
    
    int[][] dirs;
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board.length == 0 || board[0].length == 0) return board;
        
        dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};
                
        dfs(board, click[0], click[1]);
        
        return board;
    }
    
    private void dfs(char[][] board, int i, int j) {
        int m = board.length, n = board[0].length;
        
        if (board[i][j] == 'M') {
            board[i][j] = 'X';
            return;
        }
                
        // check surrounding
        int counter = 0;
        for (int[] dir : dirs) {
            int y = i + dir[0], x = j + dir[1];
            if (y >= 0 && y < m && x >= 0 && x < n) {
                if (board[y][x] == 'M') counter++;
            }
        }
        
        if (counter == 0) {
            board[i][j] = 'B';
            
            // dfs surrounding
            for (int[] dir : dirs) {
                int y = i + dir[0], x = j + dir[1];
                if (y >= 0 && y < m && x >= 0 && x < n && board[y][x] == 'E') 
                    dfs(board, y, x);
            }
        } else board[i][j] = (char) (counter + '0');
    }
}