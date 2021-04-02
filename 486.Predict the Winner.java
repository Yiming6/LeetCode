class Solution {
    /*
        dfs, enumeration. Set sums of two players and flag of which player is selecting. 
        if only one elements in array, assign the number to plays then compare.
        if more than two numbers in array, depending on which palyer, recursively run
        helper function with updated array and sums.
        O(2^n) Size of recursion tree will be 2^n Here, n refers to the length of nums array.
    */
    public boolean PredictTheWinner(int[] nums) {
        if (nums.length <= 1) return true;
        
        return helper(nums, 0, 0, 1);
    }
    
    private boolean helper(int[] nums, int sum1, int sum2, int player) {
        if (nums.length == 0) return sum1 >= sum2;
        if (nums.length == 1) return player == 1 ? sum1 + nums[0] >= sum2 : sum2 + nums[0] > sum1;
        
        if (player == 1) {
            return !helper(Arrays.copyOfRange(nums, 1, nums.length), sum1 + nums[0], sum2, 2)
                || !helper(Arrays.copyOfRange(nums, 0, nums.length - 1), sum1 + nums[nums.length - 1], sum2, 2);
        } else {
            return !helper(Arrays.copyOfRange(nums, 1, nums.length), sum1, sum2 + nums[0], 1)
                || !helper(Arrays.copyOfRange(nums, 0, nums.length - 1), sum1, sum2 + nums[nums.length - 1], 1);
        }
    }
}