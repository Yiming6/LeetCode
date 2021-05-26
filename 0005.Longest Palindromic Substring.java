class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        
        int n = s.length();
        String ans = s.substring(0, 1);
        boolean[][] dp = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            for (int j = i - 1; j >= 0; j--) {
                if (i - j == 1) dp[j][i] = s.charAt(j) == s.charAt(i);
                else dp[j][i] = dp[j + 1][i - 1] && s.charAt(j) == s.charAt(i);
                
                if (dp[j][i] && i - j + 1 > ans.length()) {
                    ans = s.substring(j, i + 1);
                }
            }
        }
        
        return ans;
    }
}