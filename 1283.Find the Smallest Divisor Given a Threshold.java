class Solution {
    /*
        Binary search. Find relative target without index. Binary search 
        numbers (results) and validate.
    */
    public int smallestDivisor(int[] nums, int threshold) {
        if (nums.length == 0) return 0;
        
        int left = 0, right = Integer.MAX_VALUE;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(nums, mid) > threshold) left = mid + 1; // abandon
            else right = mid; // keep
        }
        
        return right;
    }
    
    private int check(int[] nums, int divisor) {
        if (divisor == 0) return Integer.MAX_VALUE;
        
        int sum = 0;
        for (int n : nums) {
            if (n % divisor == 0) sum += n / divisor;
            else sum += n / divisor + 1;
        }
        
        return sum;
    }
}