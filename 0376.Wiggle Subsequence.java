class Solution {
    /*
        Two dp arrays. one to record the increasing elements the other record
        decreasing elements. For each i check j from 0 to i, if nums[i] > nums[j], update
        increasing by using descreasing one else the same.
        Equation: increasing[i] = max(decreasing[j] + 1, increasing[i]) if nums[i] > nums[j]
        decreasing[i] = max(increasing[j] + 1, decreasing[i]) if nums[i] < nums[j]
    */
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) return 0;
        
        int n = nums.length;
        int[] p = new int[n], q = new int[n];
        
        Arrays.fill(p, 1);
        Arrays.fill(q, 1);
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) p[i] = Math.max(q[j] + 1, p[i]);
                else if (nums[i] < nums[j]) q[i] = Math.max(p[j] + 1, q[i]);
            }
        }
        
        return Math.max(p[n - 1], q[n - 1]);
    }
}