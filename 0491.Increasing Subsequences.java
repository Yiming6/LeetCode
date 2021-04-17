class Solution {
    /*
        dfs to find subsequence. Enumerate all possible increasing subsequences.
        Note to avoid duplicate element by using a hashset.
        O(2^n)
    */
    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums.length < 2) return new ArrayList<>();
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        helper(nums, 0, list, ans);
        
        return ans;
    }
    
    private void helper(int[] nums, int start, List<Integer> list, List<List<Integer>> ans) {
        if (list.size() >= 2) ans.add(new ArrayList<>(list));
        

        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if ((list.size() != 0 && nums[i] < list.get(list.size() - 1)) || set.contains(nums[i])) continue;
            
            set.add(nums[i]);
            
            list.add(nums[i]);
            helper(nums, i + 1, list, ans);
            list.remove(list.size() - 1);
        }
    }
}