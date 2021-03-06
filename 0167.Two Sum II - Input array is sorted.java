class Solution {
    /*
        two pointers. one in the left, the other one in the right. if sum of current
        elements less than target, left++, else if sum larget than target, right--;
        O(n);
    */
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length == 0) return new int[]{-1, -1};
        
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] < target) left++;
            else if (numbers[left] + numbers[right] > target) right--;
            else return new int[]{left + 1, right + 1};
        }
        
        return new int[]{-1, -1};
    }
}