class Solution {
    /*
        Pre-process then binary search. To find the least index that no less than target.
        Similar question: Heater.
    */
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        if (colors.length == 0 || queries.length == 0) return new ArrayList<>();
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= 3; i++) map.put(i, new ArrayList<>());
        
        for (int i = 0; i < colors.length; i++) map.get(colors[i]).add(i);
        
        List<Integer> ans = new ArrayList<>();
        for (int[] query : queries) {
            int target = query[0], color = query[1];
            List<Integer> list = map.get(color);
            
            if (list.size() == 0) {
                ans.add(-1);
                continue;
            }
            
            int left = 0, right = list.size();
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (list.get(mid) < target) left = mid + 1;
                else right = mid;
            }
            
            if (right == list.size()) ans.add(target - list.get(right - 1));
            else if (right == 0) ans.add(list.get(right) - target);
            else ans.add(Math.min(Math.abs(list.get(right) - target), Math.abs(list.get(right - 1) - target)));
        }
        
        return ans;
    }
}