class Solution {
    
    int[] sum;
    public Solution(int[] w) {
        if (w.length == 0) return;
        
        sum = new int[w.length];
        sum[0] = w[0];
        for (int i = 1; i < w.length; i++) sum[i] = sum[i - 1] + w[i];
    }
    
    public int pickIndex() {
        int target = (int) (sum[sum.length - 1] * Math.random()), left = 0, right = sum.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (sum[mid] <= target) left = mid + 1;
            else right = mid;
        }
        
        return right;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */