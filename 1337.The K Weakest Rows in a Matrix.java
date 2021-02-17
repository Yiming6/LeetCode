class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
        
        for (int i = 0; i < mat.length; i++) {
            int weakness = weakness(mat[i]);
            if (!map.containsKey(weakness)) map.put(weakness, new TreeSet<>());
            map.get(weakness).add(i);
        }
        
        int[] ans = new int[k];
        int index = 0;
        for (int w : map.keySet()) {
            for (int i : map.get(w)) {
                ans[index++] = i;
                if (index == k) return ans;
            }
        }
        
        return new int[0];
    }
    
    private int weakness(int[] row) {
        int left = 0, right = row.length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (row[mid] == 1) left = mid + 1;
            else right = mid;
        }
        
        return right;
    }
}