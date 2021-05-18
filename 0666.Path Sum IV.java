class Solution {
    int ans;
    public int pathSum(int[] nums) {
        if (nums.length == 0) return 0;
        
        // 1, 2, 4, 8
        int[] tree = new int[16];
        Arrays.fill(tree, -1);
        
        for (int num : nums) {
            int value = num % 10; // unit
            num = num / 10;
            int position = num % 10; // tens
            int depth = num / 10; // hundreds
            
            depth--;
            position = (int) Math.pow(2, depth) + position - 1;
            
            tree[position] = value;
        }
        
        ans = 0;
        helper(tree, 0, 1);
        
        return ans;
    }
    
    private void helper(int[] tree, int curr, int position) {
        if (position >= tree.length || tree[position] == -1) return;
        
        curr += tree[position];
        
        int left = position * 2, right = position * 2 + 1;
        
        if ((left >= tree.length || tree[left] == -1) && (right >= tree.length || tree[right] == -1)) {
            ans += curr;
            return;
        }
        
        helper(tree, curr, left);
        helper(tree, curr, right);
    }
}