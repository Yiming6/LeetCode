class Solution {
    /*
        Binary search. Find relative target without index. Binary search numbers (results) 
        and validate.
        Note the function to count the kth missed element.
    */
    
    public int missingElement(int[] nums, int k) {
        if (nums.length == 0) return 0;
        
        int left = nums[0], right = nums[nums.length - 1] + k;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (count(nums, mid) < k) left = mid + 1;
            else right = mid;
        }
        
        return right;
    }
    
    private int count(int[] nums, int target) {
        int count = 0;
        
        count = target - nums[0] + 1;
        for (int n : nums) {
            if (n <= target) count--;
        }
        
        return count;
    }
}