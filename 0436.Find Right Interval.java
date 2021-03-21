class Solution {
    /*
        Because start time is unique, we can add start time to list and sort and then 
        apply binary search. Preprocess then binary search.
        O(nlogn).
    */
    public int[] findRightInterval(int[][] intervals) {
        if (intervals.length == 0) return new int[0];
        if (intervals.length == 1) return new int[]{-1};
        
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < intervals.length; i++) {
            list.add(intervals[i][0]);
            map.put(intervals[i][0], i);
        }
        
        Collections.sort(list);
        
        int[] ans = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            int end = intervals[i][1];
            
            int left = 0, right = list.size();
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (list.get(mid) < end) left = mid + 1;
                else right = mid;
            }
            
            if (right == list.size()) ans[i] = -1;
            else ans[i] = map.get(list.get(right));
        }
        
        return ans;
    }
}