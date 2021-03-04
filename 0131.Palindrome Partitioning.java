class Solution {
    /*
        dfs.
        Basically, find all partions and check whether they are all palindrome strings.
        Recursively in one string, check the start to current position is palindrome or not.
        If it is, add it in the list, otherwise continue to next position. 
        And let the same method to handle rest of part of this string.
        O(n*2^n)
    */
    public List<List<String>> partition(String s) {
        if (s.length() == 0) return new ArrayList<>();
        
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        
        helper(s, 0, ans, list);
        
        return ans;
    }
    
    private void helper(String s, int start, List<List<String>> ans, List<String> list) {
        if (start >= s.length()) {ans.add(new ArrayList<>(list)); return;}
        
        for (int i = start; i < s.length(); i++) {
            String curr = s.substring(start, i + 1);
            if (isPalindrome(curr)) list.add(curr);
            else continue;
            
            helper(s, i + 1, ans, list);
            
            list.remove(list.size() - 1);
        }
    }
    
    private boolean isPalindrome(String s) {
        if (s.length() == 0) return false;
        
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        
        return true;
    }
}