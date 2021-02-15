class Solution {
    /*
        Binary search every rows. Fixed target.
    */
    public int smallestCommonElement(int[][] mat) {
        if (mat.length == 0 || mat[0].length == 0) return -1;
        
        for (int target : mat[0]) {
            int counter = mat.length - 1;
            for (int i = 1; i < mat.length; i++) {
                int left = 0, right = mat[i].length;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (mat[i][mid] == target) {
                        counter--;
                        if (counter == 0) return mat[i][mid];
                        break;
                    } else if (mat[i][mid] < target) left = mid + 1;
                    else right = mid;
                }
            }
        }
        
        return -1;
    }
}