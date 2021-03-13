class Solution {
    /*
        Binary search. Note to set left right mid to long integer to avoid overflow.
        Use mid * mid not num / mid due to the accuracy
        O(n).
    */
    public boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1) return true;
        
        long left = 1, right = num;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == num) return true;
            else if (mid < num / mid) left = mid + 1;
            else right = mid;
        }
        
        return false;
    }
}