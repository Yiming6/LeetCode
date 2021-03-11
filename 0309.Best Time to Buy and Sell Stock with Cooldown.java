class Solution {
    /*
        We need three dp arrays to record the maximum profit if ith day we buy or sell or cd
        Equation:
        buy[i] = max(reset[i - 1] - price, buy[i - 1]);
        sell[i] = max(buy[i - 1] + price, sell[i - 1]);
        reset[i] = max(buy[i - 1], sell[i - 1], reset[i - 1]);
        O(n).
        
    */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        
        int n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];
        int[] reset = new int[n];
        
        buy[0] = 0 - prices[0];
        
        for (int i = 1; i < n; i++) {
            buy[i] = Math.max(reset[i - 1] - prices[i], buy[i - 1]);
            sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1]);
            reset[i] = Math.max(reset[i - 1], Math.max(buy[i - 1], sell[i - 1]));
        }
        
        return Math.max(buy[n - 1], Math.max(sell[n - 1], reset[n - 1]));
    }
}