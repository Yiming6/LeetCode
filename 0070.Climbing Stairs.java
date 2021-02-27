class Solution {
    /*
        dp. Round up numbers.
        Every step that can be reached is the sum of the number of 1 step before and 2 steps
        before;
        
        dp[n] = dp[n - 1] + dp[n - 2];
    */
    public int climbStairs(int n) {
        if (n == 0) return 0;
        
        int[] dp = new int[n + 1];
        dp[0] = 1; dp[1] = 1;
        
        for (int i = 2; i <= n; i++) 
            dp[i] = dp[i - 1] + dp[i - 2];
        
        return dp[n];
    }
}