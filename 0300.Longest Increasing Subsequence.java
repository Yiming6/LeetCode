class Solution {
    /*
        dp arrays to record the maximum length of increasing sequence when the array ends at
        position i, check from 0 to i - 1, if nums[i] > nums[j], which means current number 
        can be add into that increasing sequence, which recorded in dp[j].
        Equation: dp[i] = dp[j] + 1 if nums[i] + nums[j];
        O(n ^ 2).
    */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        
        int n = nums.length, ans = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
                ans = Math.max(ans, dp[i]);
            }
        }
        
        return ans;
    }
}