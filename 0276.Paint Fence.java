class Solution {
    /*
        dp. for each one, the result is two parts, diff and same. the diff is 
        straightforward previous result times (k - 1), and same is different part 
        of previous result. and result for each is sum of same and diff.
        O(n).
    */
    public int numWays(int n, int k) {
        if (n == 0 || k == 0) return 0;
        
        int same = 0, diff = k;
        
        for (int i = 1; i < n; i++) {
            int temp = diff;
            diff = (same + diff) * (k - 1);
            same = temp;
        }
        
        return same + diff;
    }
}