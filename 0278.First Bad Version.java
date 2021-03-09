/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    /*
        binary search, if it is bad, left = mid + 1, if it is good, right = mid.
        Finally return right.
    */
    public int firstBadVersion(int n) {
        if (n == 0) return 0;
        
        int left = 0, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (!isBadVersion(mid)) left = mid + 1;
            else right = mid;
        }
        
        return right;
    }
}