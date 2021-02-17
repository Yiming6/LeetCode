class Solution {
    /*
        Binary search. Find relative target without index. Binary search 
        numbers (results) and validate. Note that we need to find the result
        that is cloest to target, so we need to compare right and right - 1.
        Similar question: heater.
    */
    public int findBestValue(int[] arr, int target) {
        if (arr.length == 0) return 0;
        
        int max = 0;
        for (int a : arr) max = Math.max(max, a);
        
        int left = 0, right = max;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(arr, mid) < target) left = mid + 1;
            else right = mid;
        }
        
        if (right == target + 1 || right == 0) return right;
        return Math.abs(check(arr, right) - target) >= Math.abs(check(arr, right - 1) - target) ? right - 1 : right;
    }
    
    private int check(int[] arr, int value) {
        int sum = 0;
        for (int a : arr) {
            if (a >= value) sum += value;
            else sum += a;
        }
        
        return sum;
    }
}