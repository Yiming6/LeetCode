class TimeMap {
    
    Map<String, List<Pair<Integer, String>>> map;

    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (timestamp == 0) return;
        
        if (!map.containsKey(key)) map.put(key, new ArrayList<>());
        
        map.get(key).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (timestamp == 0) return new String();
        
        List<Pair<Integer, String>> list = map.get(key);
        
        int left = 0, right = list.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (list.get(mid).getKey() <= timestamp) left = mid + 1;
            else right = mid;
        }
        
        return right == 0 ? "" : list.get(right - 1).getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */