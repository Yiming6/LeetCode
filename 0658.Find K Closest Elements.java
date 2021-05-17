class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr.length == 0) return new ArrayList<>();
        
        List<Integer> ans = new ArrayList<>();
        for (int a : arr) ans.add(a);
        
        while (ans.size() > k) {
            int left = 0, right = ans.size() - 1;
            if (Math.abs(ans.get(left) - x) > Math.abs(ans.get(right) - x)) ans.remove(left);
            else ans.remove(right);
        }
        
        return ans;
    }
}