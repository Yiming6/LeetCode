class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() == 1) return s.length();
        
        int i = 0, left = -1, ans = 1;
        int[] position = new int[128];
        
        Arrays.fill(position, -1);
        
        while (i < s.length()) {
            char curr = s.charAt(i);
            
            left = Math.max(left, position[curr]);
            
            ans = Math.max(ans, i - left);
            
            position[curr] = i;
            
            i++;
        }
        
        return ans;
    }
}