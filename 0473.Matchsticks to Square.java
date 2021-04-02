class Solution {
    /*
        set a array with length of 4 to represent each side of square and find all 
        possible combinations. Validate whether it is a square when at the last number.
        To speed it up, we compare it with target which is the length of one side. If 
        it is larger than the target value, we can omit it and check next.
        O(n * 2^n).
    */
    public boolean makesquare(int[] nums) {
        if (nums.length < 4) return false;
        
        int sum = 0;
        for (int num : nums) sum += num;
        
        if (sum % 4 != 0) return false;
        
        int target = sum / 4;
        int[] square = new int[4];
        
        return helper(nums, square, 0, target);
    }
    
    private boolean helper(int[] nums, int[] square, int curr, int target) {
        if (curr >= nums.length) return false;
        
        for (int i = 0; i < 4; i++) {
            if (square[i] + nums[curr] > target) continue;
            
            square[i] += nums[curr];
            
            if (curr == nums.length - 1) {
                if (square[0] == target && square[1] == target && square[2] == target)
                    return true;
            }
            
            if (helper(nums, square, curr + 1, target)) return true;
            
            square[i] -= nums[curr];
        }
        
        return false;
    }
}