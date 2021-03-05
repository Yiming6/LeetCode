class Solution {
    /*
        dp. contiguous subarray problem.
        two array to record current max and min value.
        O(n)
    */
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        
        int n = nums.length, ans = nums[0];
        int[] max = new int[n];
        int[] min = new int[n];
        
        max[0] = nums[0];
        min[0] = nums[0];
        
        for (int i = 1; i < n; i++) {
            max[i] = Math.max(nums[i], Math.max(max[i - 1] * nums[i], min[i - 1] * nums[i]));
            min[i] = Math.min(nums[i], Math.min(max[i - 1] * nums[i], min[i - 1] * nums[i]));
            
            ans = Math.max(ans, max[i]);
        }
        
        return ans;
    }
}