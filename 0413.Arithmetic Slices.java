class Solution {
    /*
        dp. Use a dp array to record the number of subarrays that end at current position.
        If the consecutive three elements can be a arithmetic array, current element can be
        added into previous subarray, and total number can plus 1. Note the final result is
        to return total number of subarrays, so we need to accumlate all results.
        O(n).
    */
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) return 0;
        
        int n = nums.length, ans = 0;
        int[] dp = new int[n];
                
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                ans += dp[i];
            }
        }
        
        return ans;
    }
}