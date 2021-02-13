class Solution {
    /*
        Find relative target without index. Binary search numbers (results) and validate.
    */
    public int shipWithinDays(int[] weights, int D) {
        if (weights.length == 0) return 0;
        
        int left = 0, right = Integer.MAX_VALUE;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (days(weights, mid) > D) left = mid + 1;
            else right = mid;
        }
        
        return right;
    }
    
    private int days(int[] weights, int capacity) {
        if (capacity == 0) return Integer.MAX_VALUE;
        
        int days = 0, weight = 0;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > capacity) return Integer.MAX_VALUE;
            
            if (weight + weights[i] > capacity) {
                days++;
                weight = weights[i];
            } else weight += weights[i];
        }
        
        return days + 1;
    }
}