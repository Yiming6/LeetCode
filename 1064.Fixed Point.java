class Solution {
    /*
        Binary search. Find smallest element that satisfy requirement in sorted 
        array with index, relative target.
    */
    public int fixedPoint(int[] arr) {
        if (arr.length == 0) return -1;
        
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < mid) left = mid + 1;
            else right = mid;
        }
        
        return right == arr.length || arr[right] != right ? -1 : right;
    }
}