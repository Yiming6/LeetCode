class Solution {
    
    int ans;
    public int countArrangement(int n) {
        if (n == 0 || n == 1) return n;
        
        ans = 0;
        boolean[] used = new boolean[n + 1];
        helper(n, 1, used);
        
        return ans;
    }
    
    private void helper(int n, int curr, boolean[] used) {
        if (curr > n) {
            ans++;
            return;
        }
        
        for (int i = 1; i <= n; i++) {
            if (!used[i] && (curr % i == 0 || i % curr == 0)) {
                used[i] = true;
                helper(n, curr + 1, used);
                used[i] = false;
            }
        }
    }
}