class Solution {
    /*
        Using a array to record the last positon of character. if current character has appeared before, move
        left pointer to that position. Update last one position for each characters.
        O(n).
    */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();
        
        int left = -1, ans = 0;
        int[] counter = new int[128];
        
        Arrays.fill(counter, -1);
        
        for (int i = 0 ; i < s.length(); i++) {
            left = Math.max(left, counter[s.charAt(i)]);
            
            counter[s.charAt(i)] = i;
            
            ans = Math.max(ans, i - left);
        }
        
        return ans;
    }
}