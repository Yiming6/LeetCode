class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if (piles.length == 0) return 0;
        if (h == 0) return Integer.MAX_VALUE;
        
        int left = 0, right = 0;
        for (int p : piles) right = Math.max(right, p);
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (cost(piles, mid) > h) left = mid + 1;
            else right = mid;
        }
        
        return right;
    }
    
    private int cost(int[] piles, int k) {
        if (k == 0) return Integer.MAX_VALUE;
        
        int hour = 0;
        for (int p : piles) {
            if (p % k == 0) hour += p / k;
            else hour += p / k + 1;
        }
        
        return hour;
    }
}