class Solution {
    /*
        dp. Sort the array and update dp array from end to start.
        because the nums array was sorted, if larger numbers can be divided by smaller
        the current position can be updated if it is bigger.
        Note to create a parent array and index to track element
        Equation: dp[i] = max(dp[i], dp[j] + 1) if nums[j] % nums[i] == 0.
        O(n).
    */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        
        int n = nums.length, max = 0, max_id = 0;
        int[] dp = new int[n], parent = new int[n];
        
        Arrays.sort(nums);
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (nums[j] % nums[i] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                    
                    if (max < dp[i]) {
                        max = dp[i];
                        max_id = i;
                    }
                }
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            ans.add(nums[max_id]);
            max_id = parent[max_id];
        }
        
        return ans;
    }
}