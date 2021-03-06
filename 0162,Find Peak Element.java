class Solution {
    /*
        Binary search. if mid is left most or right most elements, it is the peak.
        Otherwise compare mid to mid + 1, because if mid is in the left of peak, mid < mid + 1
        then we keep right part. If mid > mid + 1, peak is in the left part.
        Note the corner case that there are one element.
        O(logn)
    */
    public int findPeakElement(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return 0;
        
        // left close, right close
        int left = 0, right = nums.length - 1;
        while (left < right) { // here, the termination condition is left == right
            int mid = left + (right - left) / 2;
            // since left cannot equal to right and right close, mid cannot reach right most
            if (nums[mid] < nums[mid + 1]) left = mid + 1; 
            else right = mid;
        }
        
        return right;
    }
}