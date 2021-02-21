class Solution {
    /*
     dp. Palindromic substring. Range traversal.
    */
    public String longestPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) return s;
        
        int n = s.length(), start = 0, len = 0;
        boolean[][] dp = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;

            for (int j = i; j >= 0; j--) {
                if (i - j == 1) dp[j][i] = s.charAt(i) == s.charAt(j);
                else if (i - j > 1) dp[j][i] = dp[j + 1][i - 1] && s.charAt(i) == s.charAt(j);
                
                if (dp[j][i] && i - j + 1 > len) {
                    start = j;
                    len = i - j + 1;
                }
            }
        }
        
        return s.substring(start, start + len);
    }
}