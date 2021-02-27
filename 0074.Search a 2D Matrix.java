class Solution {
    /*
        Because the first integer of each row is greater than the last integer of the 
        previous rot, we can search the first column to specify whic row our target
        might be.
        Binary search. First round to find the first element that larger than target.
        Second round to find the target.
        Find element greater/smaller than target in sorted array with index, fixed target.
        Find exactly target in sorted array with index, fixed target.
    */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        
        int m = matrix.length, n = matrix[0].length;
        
        int left = 0, right = m;
        // search the first column to specify which row it is
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid][0] == target) return true;
            if (matrix[mid][0] < target) left = mid + 1;
            else right = mid;
        }
        
        if (right == 0) return false;
        
        int index = right - 1;
        left = 0; right = n;
        // search in the row to find the target
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (matrix[index][mid] == target) return true;
            if (matrix[index][mid] < target) left = mid + 1;
            else right = mid;
        }
        
        return false;
    }
}