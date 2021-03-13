class Solution {
    /*
        Math problem.
    */
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        
        int[] dp = new int[n + 1];
        
        dp[0] = 1; dp[1] = 10;
        
        for (int i = 2; i <= n; i++) {
            int count = 9;
            for (int j = 9; j >= 9 - i + 2; j--) count *= j;
            
            dp[i] = dp[i - 1] + count;
        }
        
        return dp[n];
    }
}