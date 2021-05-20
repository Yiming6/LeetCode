class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        
        return -1;
    }
}