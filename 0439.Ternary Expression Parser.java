class Solution {
    /*
        Recursion. Find the point to split the input string. In this question, the split
        positions are the pair of '?' and ':'. According to the condition, return front part
        or later part.
        O(n).
    */
    public String parseTernary(String expression) {
        if (expression.length() < 5) return expression;
        
        int left = 0;
        while (expression.charAt(left) != '?') left++;
        
        int right = left + 1, cnt = 1;
        while (right < expression.length()) {
            if (expression.charAt(right) == '?') cnt++;
            if (expression.charAt(right) == ':') cnt--;
            
            if (cnt == 0) break;
            
            right++;
        }
        
        return expression.charAt(0) == 'T' ? parseTernary(expression.substring(left + 1, right)) : parseTernary(expression.substring(right + 1));
    }
}