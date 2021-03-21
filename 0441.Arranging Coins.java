class Solution {
    /*
        Binary search. Find the result and validate it. To find the first number of rows
        that total coins larger than given n. Then minus 1 is the answer.
        O(logn)
    */
    public int arrangeCoins(int n) {
        if (n == 0 || n == 1) return n;
        
        long left = 1, right = n;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (count(mid) <= n) left = mid + 1;
            else right = mid;
        }
        
        return (int) right - 1;
    }
    
    private long count(long row) {
        return (1 + row) * row / 2;
    }
}