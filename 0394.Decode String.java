class Solution {
    /*
        Dfs and recursion. Strings inner the [] can be handled by the same function.
        O(n).
    */
    public String decodeString(String s) {
        if (s.length() == 0) return "";
        
        int curr = 0, num = 0;
        StringBuilder sb = new StringBuilder();
        
        while (curr < s.length()) {
            while (curr < s.length() && s.charAt(curr) >= 'a' && s.charAt(curr) <= 'z') sb.append(s.charAt(curr++));
                
            while (curr < s.length() && s.charAt(curr) >= '0' && s.charAt(curr) <= '9') num = num * 10 + s.charAt(curr++) - '0';
            
            int end = curr + 1, counter = 1;
            while (end < s.length() && counter > 0) {
                if (s.charAt(end) == '[') counter++;
                if (s.charAt(end) == ']') counter--;
                
                end++;
            }
            
            String inner = end - 1 > curr + 1 ? decodeString(s.substring(curr + 1, end - 1)) : "";
            while (num > 0) {sb.append(inner); num--;}
            
            curr = end;
        }
        
        return sb.toString();
    }
}