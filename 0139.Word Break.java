class Solution {
    /*
        dp. Round up strings.
        Create a dp array which length is n + 1, for each position i from 1 to n + 1,
        it represented whether the dictionary can form the string from 1 to i.
        for each string in dictionary, if its length is l, if dp[l] is true and
        substring(i - l, i) equals to this string, then dp[i] is true, because the strings
        in dic can be reused.
        Note only update when current position is false, otherwise upcoming strings will 
        reset the current position to false.
        O(mn).
    */
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0 || wordDict.size() == 0) return false;
        
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        
        dp[0] = true;
        
        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {
                if (word.length() <= i && !dp[i]) {
                    dp[i] = dp[i - word.length()] && word.equals(s.substring(i - word.length(), i));
                }
            }
        }
        
        return dp[n];
    }
}