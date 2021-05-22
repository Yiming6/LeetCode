class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        if (arr.length == 0) return 0;
        
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid + 1]) left = mid + 1;
            else right = mid;
        }
        
        return right;
    }
}