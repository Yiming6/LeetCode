class Solution {
    /*
        dp or Prefix sum. Subarray.
    */
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        
        int n = nums.length, ans = nums[0];
        int[] dp = new int[n];
        
        dp[0] = nums[0];
        
        for (int i = 1; i < n; i++) {
            if (dp[i - 1] > 0) dp[i] = nums[i] + dp[i - 1];
            else dp[i] = nums[i];
            ans = Math.max(ans, dp[i]);
        }
        
        return ans;
    }
}