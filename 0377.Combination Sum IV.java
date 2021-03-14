class Solution {
    /*
        Ues a dp array to record the total ways to get amount i.
        For each amount i, check the nums and for each num, if it is less than current amount
        i, then the ways can increase dp[i - num].
        Equation: dp[i] = dp[i] + dp[i - num] for each num in nums.
        O(nm).
    */
    public int combinationSum4(int[] nums, int target) {
        if (nums.length == 0 || target == 0) return 0;
        
        int n = nums.length;
        int[] dp = new int[target + 1];
        
        dp[0] = 1;
        
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) dp[i] += dp[i - num];
            }
        }
        
        return dp[target];
    }
}