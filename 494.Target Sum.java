class Solution {
    int ans;
    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0) return 0;
        
        helper(nums, S, 0);
        
        return ans;
    }
    
    private void helper(int[] nums, int sum, int curr) {
        if (curr >= nums.length) {
            if (sum == 0) ans++;
            return;
        }
        
        helper(nums, sum - nums[curr], curr + 1);
        helper(nums, sum + nums[curr], curr + 1);
    }
}