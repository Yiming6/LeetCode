class Solution {
    /*
        Binary search. If middle point larger than right end, then the minimum element
        must be in right part. Else in left part. This is opposite of normal binary search.
    */
    public int findMin(int[] nums) {
        if (nums.length == 0) return 0;
        
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[right]) left = mid + 1;
            else right = mid;
        }
        
        return nums[right];
    }
}