class Solution {
    /*
        Two times of binary search. Find the first element that no less than target and 
        the first element that greater than target. Calculate frequency of target in array.
    */
    public boolean isMajorityElement(int[] nums, int target) {
        if (nums.length == 0) return false;
        
        int start = 0, end = 0;
        
        // first time binary search.
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        
        start = right;
        
        // second time binary search.
        left = 0; right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) left = mid + 1;
            else right = mid;
        }
        
        end = right;
        
        return end - start > nums.length - (end - start);
    }
}