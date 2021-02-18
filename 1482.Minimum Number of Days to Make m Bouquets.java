class Solution {
    /*
        Binary search.
        Find relative target without index. Binary search numbers (results) and validate.
    */
    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length == 0) return 0;
        
        int left = 0, right = Integer.MAX_VALUE;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(bloomDay, k, mid) < m) left = mid + 1;
            else right = mid;
        }
        
        return right == Integer.MAX_VALUE ? -1 : right;
    }
    
    private int check(int[] bloomDay, int k, int d) {
        if (k > bloomDay.length) return 0;
        
        int m = 0, n = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= d) {
                n++;
                if (n >= k) {
                    m++;
                    n = 0;
                }
            } else n = 0;
        }
        
        return m;
    }
}