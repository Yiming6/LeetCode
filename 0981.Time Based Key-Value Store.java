class TimeMap {
    /*
        Two maps. Binary search. Fixed target, find one that no larger than target.
        Right pointer -1 is the one that no larger than target.
    */

    Map<String, List<Integer>> kToT;
    Map<Integer, String> tToV;
    /** Initialize your data structure here. */
    public TimeMap() {
        kToT = new HashMap<>();
        tToV = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!kToT.containsKey(key)) kToT.put(key, new ArrayList<>());
        kToT.get(key).add(timestamp);
        tToV.put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        List<Integer> timestamps = kToT.get(key);
        int left = 0, right = timestamps.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (timestamps.get(mid) <= timestamp) left = mid + 1;
            else right = mid;
        }
        
        return right == 0 ? "" : tToV.get(timestamps.get(right - 1));
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */