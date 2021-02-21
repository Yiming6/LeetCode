class Solution {
    /*
        Binary search. Find element greater/smaller than target in sorted array with 
        index, fixed target.
        Find the first index that larger than target
    */
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        
        return right;
    }
}