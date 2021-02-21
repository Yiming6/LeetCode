class Solution {
    /*
        Binary Search. Find exactly target in strange order array with index, fixed target
        Everytime compare nums[mid] with last element. Left part is sorted if nums[mid] > last;
        Right part is sorted if nums[mid] < last. Then check whether target in sorted part,
        otherwise in the other part.
        Note the three conditions are both close, <=, both move
    */
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < nums[right]) {
                if (nums[mid] < target && nums[right] >= target) left = mid + 1;
                else right = mid - 1;
            } else {
                if (nums[left] <= target && nums[mid] > target) right = mid - 1;
                else left = mid + 1;
            }
        }
        
        return -1;
    }
}