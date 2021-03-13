class Solution {
    /*
        dfs, find all path. Note to back track.
        O(n!)
    */
    public int numberOfPatterns(int m, int n) {
        if (n == 0 || m > n) return 0;
        
        int[][] jump = new int[10][10];
        jump[1][3] = jump[3][1] = 2;
        jump[1][7] = jump[7][1] = 4;
        jump[7][9] = jump[9][7] = 8;
        jump[3][9] = jump[9][3] = 6;
        jump[1][9] = jump[9][1] = jump[3][7] = jump[7][3] = jump[2][8] = jump[8][2] = jump[4][6] = jump[6][4] = 5;
        
        int ans = 0;
        boolean[] visited = new boolean[10];
        ans += dfs(jump, visited, 1, 1, m, n, 0) * 4;
        ans += dfs(jump, visited, 1, 2, m, n, 0) * 4;
        ans += dfs(jump, visited, 1, 5, m, n, 0);
        
        return ans;
    }
    
    private int dfs(int[][] jump, boolean[] visited, int length, int curr, int m, int n, int ans) {
        if (length >= m) ans++;
        length++;
        if (length > n) return ans;
        
        visited[curr] = true;
        
        for (int next = 1; next <= 9; next++) {
            int j = jump[curr][next];
            if (visited[next] || (j != 0 && !visited[j])) continue;
            ans = dfs(jump, visited, length, next, m, n, ans);
        }
        
        visited[curr] = false;
        
        return ans;
    }
}