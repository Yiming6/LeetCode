class Solution {
    /*
        Minmax. Created a dp array to record the minimum maximum loss in range [j, i].
        Then check every k inside j to i. Every time calculate the maximum loss in position
        k and record the minimum maximum loss as the minimum loss in range [j, i], until to
        range [1, n].
        Equation: dp[j][i] = min(k + max(dp[j][k - 1], dp[k + 1][i])).
        O(n^3).
    */
    public int getMoneyAmount(int n) {
        if (n == 1 || n == 2) return n - 1;
        
        int[][] dp = new int[n + 1][n + 1];
        
        for (int i = 2; i <= n; i++) {
            for (int j = i - 1; j > 0; j--) {
                int global_min = Integer.MAX_VALUE;
                for (int k = j + 1; k < i; k++) {
                    int local_max = k + Math.max(dp[j][k - 1], dp[k + 1][i]);
                    global_min = Math.min(global_min, local_max);
                }
                
                dp[j][i] = j + 1 == i ? j : global_min;
            }
        }
        
        return dp[1][n];
    }
}