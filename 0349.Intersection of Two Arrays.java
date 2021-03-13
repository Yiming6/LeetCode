class Solution {
    /*
        sort one of array and binary search each element of the other one.
        O(mlogn).
    */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) return new int[0];
        
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        
        for (int target : nums1) {
            int left = 0, right = nums2.length;
            
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums2[mid] == target) {set.add(nums2[mid]); break;}
                else if (nums2[mid] < target) left = mid + 1;
                else right = mid;
            }
        }
        
        int[] ans = new int[set.size()];
        int i = 0;
        for (int num : set) ans[i++] = num;
        
        return ans;
    }
}