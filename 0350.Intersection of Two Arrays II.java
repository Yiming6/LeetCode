class Solution {
    /*
        Binary search each element of one array in the other array.
        Note to use a hash table to count the element that has been consumed.
        O(mlogn).
    */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) return new int[0];
        
        Arrays.sort(nums2);
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        for (int num : nums2) map.put(num, map.getOrDefault(num, 0) + 1);
        
        for (int target : nums1) {
            int left = 0, right = nums2.length;
            
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums2[mid] == target) {
                    if (map.get(target) > 0) {
                        list.add(target);
                        map.put(target, map.get(target) - 1);
                    }
                    break;
                } else if (nums2[mid] < target) left = mid + 1;
                else right = mid;
            }
        }
        
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) ans[i] = list.get(i);
        
        return ans;
    }
}