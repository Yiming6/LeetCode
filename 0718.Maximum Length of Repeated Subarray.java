class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) return 0;
        
        int m = nums1.length, n = nums2.length, ans = 0;
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = nums1[i - 1] == nums2[j - 1] ? dp[i - 1][j - 1] + 1 : 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        
        return ans;
    }
}