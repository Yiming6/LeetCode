class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if (m == 0 || n == 0 || maxMove == 0) return 0;
        
        int[][][] dp = new int[maxMove + 1][m][n];
        
        for (int k = 1; k <= maxMove; k++) {
            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    long v1 = x == 0 ? 1 : dp[k - 1][x - 1][y];
                    long v2 = x == m - 1 ? 1 : dp[k - 1][x + 1][y];
                    long v3 = y == 0 ? 1 : dp[k - 1][x][y - 1];
                    long v4 = y == n - 1 ? 1 : dp[k - 1][x][y + 1];
                    
                    dp[k][x][y] = (int) ((v1 + v2 + v3 + v4) % 1000000007);
                }
            }
        }
        
        return dp[maxMove][startRow][startColumn];
    }
}