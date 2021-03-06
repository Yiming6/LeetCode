class Solution {
    /*
        prefix sum and binary search.
        Created a prefix sum and for each element in it, set the target as 
        the target + sums[i] and find the first one that no less than target.
        Use a global ans to record the minimum value for each start.
        O(nlogn).
    */
    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 0) return 0;
        
        int n = nums.length, ans = n + 1;
        int[] sums = new int[n + 1];
        
        sums[0] = nums[0];
        for (int i = 1; i <= n; i++) sums[i] = sums[i - 1] + nums[i - 1];
        
        for (int i = 0; i < n; i++) {
            int left = i, right = n, t = target + sums[i];
            
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (sums[mid] < t) left = mid + 1;
                else right = mid - 1;
            }
            
            if (left != n + 1) ans = Math.min(ans, left - i);
        }
        
        return ans == n + 1 ? 0 : ans;
    }
}