class Solution {
    /*
        dp. Create a dp array to record the maximum value so far. If we pick current one,
        we can not pick the former one but we can pluse it in one before previous one.
        Equation: dp[i] = max(dp[i - 1], dp[i - 2] + nums[i]);
        O(n)
    */
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        int n = nums.length;
        int[] dp = new int[n];
        
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < n; i++) dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        
        return dp[n - 1];
    }
}