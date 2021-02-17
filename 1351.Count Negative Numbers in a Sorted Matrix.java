class Solution {
    /*
        Binary search.
        Find element greater/smaller than target in sorted array with index, fixed target.
    */
    public int countNegatives(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        
        int ans = 0;
        for (int[] row : grid) {
            int left = 0, right = row.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (row[mid] >= 0) left = mid + 1;
                else right = mid;
            }
            
            ans += row.length - right;
        }
        
        return ans;
    }
}