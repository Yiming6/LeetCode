class Solution {
    /*
        Binary search to find relative position. Every time for each house find the closest 
        heaters (candidates can be right closest one and left closest one, if any) then find
        the minimum distance to any of it and then keep the global maximum distance.
        O(nlogn).
    */
    public int findRadius(int[] houses, int[] heaters) {
        if (houses.length == 0) return 0;
        
        int ans = 0, n = heaters.length;
        Arrays.sort(heaters);
        
        for (int house : houses) {
            int left = 0, right = n;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (heaters[mid] < house) left = mid + 1;
                else right = mid;
            }
            
            int dis1 = right == n ? Integer.MAX_VALUE : heaters[right] - house;
            int dis2 = right == 0 ? Integer.MAX_VALUE : house - heaters[right - 1];
            
            ans = Math.max(ans, Math.min(dis1, dis2));
        }
        
        return ans;
    }
}