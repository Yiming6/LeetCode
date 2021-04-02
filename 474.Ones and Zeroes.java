class Solution {
    /*
        Dp, round up number in 2D. Created a 2D dp array to represent the maximum subset
        when 0 at max i and 1 at max j. For each string, calculate its number of 1 and 0,
        and use (0 ~ m - zero) to update i and (0 ~ n - one) to update j.
        Equation: dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one]) for str with zero 0
        and one 1.
        O(mn).
    */
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs.length == 0) return 0;
        
        int[][] dp = new int[m + 1][n + 1];
        
        for (String str : strs) {
            int zero = 0, one = 0;
            for (char ch : str.toCharArray()) {
                if (ch == '0') zero++;
                else one++;
            }
            
            for (int i = m; i >= zero; i--) {
                for (int j = n; j >= one; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
                }
            }
        }
        
        return dp[m][n];
    }
}