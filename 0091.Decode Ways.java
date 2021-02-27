class Solution {
    /*
        Conditional round up numbers. Every dp[i] we can add dp[i - 1] and dp[i - 2].
        But if we want to add dp[i - 1] we need to make sure s.char(i - 1) != '0'.
        If we want to add dp[i - 2] we need to make sure s.charAt(i - 2) and s.charAt(i - 1)
        can form '10' to '26';
    */
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') return 0;
        
        int n = s.length();
        int[] dp = new int[n + 1];
        
        dp[0] = 1; dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (s.charAt(i - 1) == '0') {
                if (s.charAt(i - 2) != '1' && s.charAt(i - 2) != '2') return 0;
            } else dp[i] = dp[i - 1];
            
            if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '6')) dp[i] += dp[i - 2];
        }
        
        return dp[n];
    }
}