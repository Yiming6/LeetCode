/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    /*
        binary search.
        O(logn)
    */
    public int guessNumber(int n) {
        if (n == 0 || n == 1) return n;
        
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (guess(mid) == 0) return mid;
            else if (guess(mid) > 0) left = mid + 1;
            else right = mid;
        }
        
        return right;
    }
}