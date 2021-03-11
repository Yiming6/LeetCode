class Solution {
    /*
        Round up numbers. 
        Created a dp array to record the min number of coin to get amount i. Every time
        to check every coin, the number of coin to get i depends on the number of coin to
        get i - coin and then + 1.
        Note to initilize the dp array to Integer.MAX_VALUE - 1 to avoid over flow.
        O(amount * number of coins).
    */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1); // initilize to max integer-1 to avoid overflow
        
        dp[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
            }
        }
        
        return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
    }
}