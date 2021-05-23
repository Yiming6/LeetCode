class TopVotedCandidate {
    int[] times;
    Map<Integer, Integer> map;
    public TopVotedCandidate(int[] persons, int[] times) {
        if (persons.length == 0 || times.length == 0) return;
        
        this.times = times;
        map = new HashMap<>();
        
        int[] vote = new int[persons.length + 1];
        int max = 0, leading = 0;
        
        for (int i = 0; i < times.length; i++) {
            if (++vote[persons[i]] >= max) {
                leading = persons[i];
                max = vote[persons[i]];
            }
            
            map.put(times[i], leading);
        }
    }
    
    public int q(int t) {
        if (t == 0) return 0;
        
        int left = 0, right = times.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (times[mid] <= t) left = mid + 1;
            else right = mid;
        }
        
        return map.get(times[right - 1]);
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */