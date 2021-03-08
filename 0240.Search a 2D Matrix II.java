class Solution {
    /*
        Two methods.
        Method 1, two pointers, starting from left bottom. If current larget than target,
        move up, less than target, move right. O(mn).
        Method 2, binary search. Search each row to find the target. O(mlogn).
    */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        
        int m = matrix.length, n = matrix[0].length;
//         int p = m - 1, q = 0;
        
//         while (p >= 0 && q < n) {
//             if (matrix[p][q] == target) return true;
//             else if (matrix[p][q] < target) q++;
//             else p--;
//         }
        
        for (int i = 0; i < m; i++) {
            int left = 0, right = n;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (matrix[i][mid] == target) return true;
                else if (matrix[i][mid] < target) left = mid + 1;
                else right = mid;
            }
        }
        
        return false;
    }
}