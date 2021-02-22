class Solution {
    /*
        DFS, Recursion, Enumeration.
    */
    public boolean makesquare(int[] nums) {
        if (nums.length < 4) return false;
        
        int sum = 0;
        for (int num : nums) sum += num;
        
        if (sum % 4 != 0) return false;
        
        int[] sides = new int[]{0, 0, 0, 0};
        int curr = 0, target = sum / 4;
        
        return dfs(nums, sides, curr, target);
    }
    
    private boolean dfs(int[] nums, int[] sides, int curr, int target) {
        if (curr >= nums.length) return false;
        
        for (int i = 0; i < sides.length; i++) {
            if (sides[i] + nums[curr] > target) continue;
            
            sides[i] += nums[curr];
            
            if (curr == nums.length - 1) {
                if (sides[0] == target && sides[1] == target && sides[2] == target) 
                    return true;
            }
            
            if (dfs(nums, sides, curr + 1, target)) return true;
            
            sides[i] -= nums[curr];
        }
        
        return false;
    }
}