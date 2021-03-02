class Solution {
    /*
        traversal graph.
    */
    
    int[][] dirs;
    public int findLonelyPixel(char[][] picture) {
        if (picture.length == 0 || picture[0].length == 0) return 0;
        
        int m = picture.length, n = picture[0].length, ans = 0;
        dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'W') continue;
                
                if (dfs(picture, i, j)) ans++;
            }
        }
        
        return ans;
    }
    
    private boolean dfs(char[][] picture, int i, int j) {
        int m = picture.length, n = picture[0].length;
        
        for (int[] dir : dirs) {
            int y = i + dir[0], x = j + dir[1];
            while (y >= 0 && y < m && x >= 0 && x < n) {
                if (picture[y][x] == 'B') return false;
                y += dir[0];
                x += dir[1];
            }
        }
        
        return true;
    }
}