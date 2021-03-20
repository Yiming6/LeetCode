class Solution {
    /*
        dp, round up numbers. The target should be half of the total sum of input array.
        We juse need to check whether the target can be reached by using the numbers once.
        Note the difference between use element once and multiple times.
        O(nm)
    */
    public boolean canPartition(int[] nums) {
        if (nums.length == 0) return true;
        
        int sum = 0;
        for (int num : nums) sum += num;
        
        if (sum % 2 == 1) return false;
        
        int target = sum / 2;
        
        boolean[] dp = new boolean[target + 1];
        Set<Integer> used = new HashSet<>();
        
        dp[0] = true;
        
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            } 
        }
        
        return dp[target];
    }
}