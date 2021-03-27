class Solution {
    /*
        Using a map to record the sums of first two arrays, and check last two arrays
        whether there are sums that can be added to zero.
        O(n^2).
    */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A.length == 0) return 0;
        
        int n = A.length, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) 
                map.put(A[i] + B[j], map.getOrDefault(A[i] + B[j], 0) + 1);
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int target = 0 - (C[i] + D[j]);
                
                if (!map.containsKey(target)) continue;
                ans += map.get(target);
            }
        }
        
        return ans;
    }
}