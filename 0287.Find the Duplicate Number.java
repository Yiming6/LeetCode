class Solution {
    /*
        Binary search. The answer is in the range of [1, n]. We use binary search
        to find mid value and validate it. Count the number of elements that less or
        equal to candidate, if the number is less or equals to candidate value, left part
        must not contain target.
        O(nlogn).
    */
    public int findDuplicate(int[] nums) {
        if (nums.length == 0) return 0;

        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2, counter = 0;
            
            for (int num : nums) {
                if (num <= mid) counter++;
            }
            
            if (counter <= mid) left = mid + 1;
            else right = mid;
        }
        
        return right;
    }
}