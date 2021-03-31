class Solution {
    /*
        dfs and backtracking. Using an array to record used numbers to avoid redundent 
        computing. And emurate all possible combination.
        O(2^n)
    */
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) return true;
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) return false;
        
        int[] state = new int[maxChoosableInteger + 1];
        Map<String, Boolean> map = new HashMap<>();
        
        return helper(state, map, desiredTotal);
    }
    
    private boolean helper(int[] state, Map<String, Boolean> map, int desiredTotal) {
        String key = Arrays.toString(state);
        if (map.containsKey(key)) return map.get(key);
        
        for (int i = 1; i < state.length; i++) {
            if (state[i] == 1) continue;
            
            state[i] = 1;
            if (i >= desiredTotal || !helper(state, map, desiredTotal - i)) {
                state[i] = 0;
                map.put(key, true);
                return true;
            }
            state[i] = 0;
        }
        
        map.put(key, false);
        return false;
    }
}