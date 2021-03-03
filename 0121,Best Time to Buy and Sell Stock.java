class Solution {
    /*
        dp.
        Create a dp array to record the current maximum profit and a variable to record
        lowest value so far.
        In ith day, the max profit should be the bigger one in dp[i - 1] and price[i] -
        lowest.
        Note to update the lowest value every time.
    */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        
        int n = prices.length, lowest = prices[0];
        int[] dp = new int[n];
        dp[0] = 0;
        
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - lowest);
            lowest = Math.min(lowest, prices[i]);
        }
        
        return dp[n - 1];
    }
}