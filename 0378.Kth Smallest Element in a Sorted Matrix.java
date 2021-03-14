class Solution {
    /*
        Binary search. find the candidate and verify it.
        O(mnlogmn);
    */
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = matrix[m - 1][n - 1];
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            int cnt = count(matrix, mid);
            if (cnt < k) left = mid + 1;
            else right = mid;
        }
        
        return right;
    }
    
    private int count(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length, i = m - 1, j = 0, ans = 0;
        
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= target) {
                ans += i + 1;
                j++;
            } else i--;
        }
        
        return ans;
    }
}