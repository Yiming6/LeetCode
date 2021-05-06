class Solution {
    
    int[][] dirs;
    public int findLonelyPixel(char[][] picture) {
        if (picture.length == 0 || picture[0].length == 0) return 0;
        
        dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = picture.length, n = picture[0].length, ans = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B') {
                    if (dfs(picture, i, j)) ans++;
                }
            }
        }
        
        return ans;
    }
    
    private boolean dfs(char[][] picture, int i, int j) {
        int m = picture.length, n = picture[0].length;
        
        for (int[] dir : dirs) {
            int y = i, x = j;
            
            while (y + dir[0] >= 0 && y + dir[0] < m && x + dir[1] >= 0 && x + dir[1] < n) {
                y += dir[0];
                x += dir[1];
                
                if (picture[y][x] == 'B') return false;
            }
        }
        
        return true;
    }
}