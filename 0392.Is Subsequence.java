class Solution {
    /*
        Two pointers. if the same, move both, if not the same, move t.
        O(n).
    */
    public boolean isSubsequence(String s, String t) {
        if (t.length() == 0) return s.length() == 0;
        
        int i = 0, j = 0, m = s.length(), n = t.length();
        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else j++;
        }
        
        return i == m;
    }
}