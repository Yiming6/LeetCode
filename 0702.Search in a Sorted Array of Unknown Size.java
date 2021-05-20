/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int left = 0, right = Integer.MAX_VALUE;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (reader.get(mid) == target) return mid;
            if (reader.get(mid) < target) left = mid + 1;
            else right = mid;
        }
        
        return -1;
    }
}