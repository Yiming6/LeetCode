class NumArray {
    /*
        Prefix sum. O(n) when build sums array. O(1) when get sum.
    */

    int[] sums;
    public NumArray(int[] nums) {
        sums = nums;
        
        for (int i = 1; i < sums.length; i++) sums[i] += sums[i - 1];
    }
    
    public int sumRange(int i, int j) {
        if (i > j) return 0;
        
        if (i == 0) return sums[j];
        
        return sums[j] - sums[i - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */