class Solution {
    /*
        Similar to question 33. We can compare nums[mid] to nums[right] to determint
        which part is sorted or not. But because there may be duplicated numbers,
        there are three situations.
    */
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;
            // if nums[mid] < nums[right]: right part is sorted
            if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            // if nums[mid] > nums[right]: left part is sorted
            } else if (nums[mid] > nums[right]) {
                if (nums[left] <= target && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            // nums[mid] == nums[right]: we cannot say which part is sorted, so we 
            // need furthur judge
            } else right--;
        }
        
        return false;
    }
}