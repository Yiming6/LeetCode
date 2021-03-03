class Solution {
    /*
        dp problem. For every elements in each row, they have to choice to reach current
        position except left most and right most. So we only need to choose the minimum value
        of previous row (i - 1, i). And we can directly modify given arrays rather than
        build a new one.
    */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0 || triangle.get(0).size() == 0) return 0;
        
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> curr = triangle.get(i), pre = triangle.get(i - 1);
            int end = curr.size() - 1;
            
            curr.set(0, pre.get(0) + curr.get(0));
            curr.set(end, pre.get(end - 1) + curr.get(end));
            
            for (int j = 1; j < end; j++) {
                curr.set(j, Math.min(pre.get(j - 1), pre.get(j)) + curr.get(j));
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for (int n : triangle.get(triangle.size() - 1)) ans = Math.min(ans, n);
        
        return ans;
    }
}