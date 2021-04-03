class Solution {
    /*
        count the frequence of value in the array and then custom sorting.
        O(nlogn).
    */
    public int[] frequencySort(int[] nums) {
        if (nums.length == 0) return new int[0];
        
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[nums.length];
        
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        
        for (int num : map.keySet()) list.add(new Pair<>(num, map.get(num)));
        Collections.sort(list, (p1, p2) -> p1.getValue() == p2.getValue() ? p2.getKey() - p1.getKey() : p1.getValue() - p2.getValue());
        
        int index = 0;
        for (Pair<Integer, Integer> p : list) {
            for (int i = 0; i < p.getValue(); i++) {
                ans[index++] = p.getKey();
            }
        }
        
        return ans;
    }
}