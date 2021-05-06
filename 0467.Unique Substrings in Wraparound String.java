class Solution {
    /*
        dp and substring. Because the s string is in sequense of alphabeta, we only need to
        check the relationship between current char with previous one and accumulate its
        number of substring. Note the way to create dp array.
        O(n).
    */
    public int findSubstringInWraproundString(String p) {
        if (p.length() == 0) return 0;
        
        int[] dp = new int[26];
        int len = 0;
        
        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || p.charAt(i - 1) - p.charAt(i) == 25)) len++;
            else len = 1;
            
            dp[p.charAt(i) - 'a'] = Math.max(dp[p.charAt(i) - 'a'], len);
        }
        
        int ans = 0;
        for (int i : dp) ans += i;
        
        return ans;
    }
}