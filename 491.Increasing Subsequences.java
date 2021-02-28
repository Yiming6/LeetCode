class Solution {
    /*
        dfs to find subsequence. Similar to question 131. 
    */
    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        dfs(nums, 0, list, ans);
        
        return ans;
    }
    
    private void dfs(int[] nums, int start, List<Integer> list, List<List<Integer>> ans) {
        if (list.size() >= 2) ans.add(new ArrayList<>(list));
        
        
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if ((!list.isEmpty() && list.get(list.size() - 1) > nums[i]) || set.contains(nums[i])) continue;
            
            set.add(nums[i]);
            list.add(nums[i]);
            dfs(nums, i + 1, list, ans);
            list.remove(list.size() - 1);
        }
    }
}