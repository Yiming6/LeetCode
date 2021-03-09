class Solution {
    /*
        dp, round up numbers.
        created a dp array to record the minimum numbers that needed to get the 
        sum of current number and initialize to maximum integer, dp[0] = 0, 
        dp[1] = 1;
        for each i from 2 to n, check from 1 to ceil(sqart(i)), the number that have sum
        of current number can be figured out by dp[i - j^2] + 1, and update dp[i] if we 
        find smaller result.
        Equation: dp[i] = min(dp[i], dp[i - j^2] + 1);
        O(n^2).
    */
    public int numSquares(int n) {
        if (n == 0 || n == 1) return n;
        
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            for (double j = 1; j <= Math.sqrt(i); j++) {
                dp[i] = Math.min(dp[i], dp[i - (int)Math.pow(j, 2)] + 1);
            }
        }
        
        return dp[n];
    }
}