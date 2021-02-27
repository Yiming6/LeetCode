class Solution {
    /*
        Binary search. Find the first element that larger than target.
        Find relative target without index. Binary search numbers (results) and validate.
    */
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        
        int left = 0, right = x;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // find the first element that larger than target (sqart(x));
            if (mid <= x / mid) left = mid + 1;
            else right = mid;
        }
        
        return right - 1;
    }
}