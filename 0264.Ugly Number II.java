class Solution {
    /*
        The sequence of ugly number is the combination of multiple of 2, 3, 5.
        We set index of multiple of 2, 3, 5. Every time get number from list and 
        times 2, 3, 5. Choose the minimum one and the is the one we will add into
        the list and in the same time, the corresponding index plus 1.
        O(n).
    */
    public int nthUglyNumber(int n) {
        if (n == 0) return 0;
        
        List<Integer> ans = new ArrayList<>();
        int i2 = 0, i3 = 0, i5 = 0;
        ans.add(1);
        
        while (ans.size() < n) {
            int m2 = ans.get(i2) * 2, m3 = ans.get(i3) * 3, m5 = ans.get(i5) * 5;
            int mn = Math.min(m2, Math.min(m3, m5));
            if (mn == m2) i2++;
            if (mn == m3) i3++;
            if (mn == m5) i5++;
            ans.add(mn);
        }
        
        return ans.get(ans.size() - 1);
    }
}