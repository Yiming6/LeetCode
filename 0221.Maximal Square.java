class Solution {
    /*
        dp.
        we need a m * n dp array to record current maximum length and a variable to 
        record the final answer. Initialize the top and left margins, if there is '1',
        mark dp to 1. Then traversal all graph, if current position is '1', if and only if
        its top, left and top left be '1', that current position can be added into that 
        sqare and this sqare length can add 1.
        Equation: dp[i][j] = min(dp[i - 1][j - 1], min(dp[i][j - 1], dp[i - 1][j])) + 1.
        O(mn).
    */
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int m = matrix.length, n = matrix[0].length, ans = 0;
        int[][] dp = new int[m][n];
        
        
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            ans = Math.max(ans, dp[i][0]);
        }
        
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
            ans = Math.max(ans, dp[0][i]);
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        
        return ans * ans;
    }
}