class Solution {
    /*
        dp, conditionally picking. Create a dp array to record the maximum length when 
        the subarray ends at current position. Check all element from start to current
        calculate all differents and record the length for this difference.
        Equation: dp[i][A[i] - A[j]] = dp[j][A[i] - A[j]] + 1;
        O(n^2);
    */
    public int longestArithSeqLength(int[] A) {
        if (A.length <= 2) return A.length;
        
        int ans = 2, n = A.length;
        Map<Integer, Integer>[] dp = new HashMap[n];
        
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            
            for (int j = 0; j < i; j++) {
                int diff = A[i] - A[j];
                dp[i].put(diff, dp[j].getOrDefault(diff, 1) + 1);
                
                ans = Math.max(ans, dp[i].get(diff));
            }
        }
        
        return ans;
    }
}