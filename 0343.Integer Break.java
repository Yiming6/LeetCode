class Solution {
    /*
        dp. Created a dp array to record the maximum product for each number. For each number,
        traversal from 1 to i - 1, and the maximum product is this part times dp[i - j] 
        plus one situation, which is j * (i - j). Because in the dp array, every number 
        must be seperate into at least two parts, so it doesn't contain i - j itself. 
        O(n).
    */
    public int integerBreak(int n) {
        if (n == 2) return 1;
        
        int[] dp = new int[n + 1];
        
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
            }
        }
        
        return dp[n];
    }
}