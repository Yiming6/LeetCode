class Solution {
    /*
        Binary search. Find element greater/smaller than target in sorted array with 
        index, fixed target.
        Firstly, need to find the first element that no less than target.
        Secondly, need to find the first element that larger than target. Minus one is 
        the last element that no larger than target.
        Note that the first result need to be checked bacause target might not exist 
        in the array.
    */
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        
        int[] ans = new int[]{-1, -1};
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        
        if (right == nums.length || nums[right] != target) return ans;
        
        ans[0] = right;
        
        left = 0; right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) left = mid + 1;
            else right = mid;
        }
                
        ans[1] = right - 1;
        
        return ans;
    }
}