class Solution {
    /*
        dfs (or recursion). Enumerate all possible permutaions.
        
    */
    
    int ans;
    public int countArrangement(int n) {
        if (n == 0 || n == 1) return n;
        
        boolean[] used = new boolean[n + 1];
        ans = 0;
        helper(n, 1, used);
        
        return ans;
    }
    
    private void helper(int n, int num, boolean[] used) {
        if (num > n) {
            ans++;
            return;
        }
        
        // for current number check its positions
        for (int i = 1; i <= n; i++) {
            // if current position is not used and makes it beautiful, check next number
            if (!used[i] && (num % i == 0 || i % num == 0)) {
                used[i] = true;
                helper(n, num + 1, used);
                used[i] = false;
            }
        }
    }
}