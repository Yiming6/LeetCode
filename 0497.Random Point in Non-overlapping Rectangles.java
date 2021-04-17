class Solution {
    int[][] rects;
    public Solution(int[][] rects) {
        this.rects = rects;
    }
    
    public int[] pick() {
        int sumArea = 0;
        int[] selected = new int[4];
        for (int[] rect : rects) {
            int area = (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            sumArea += area;
            if ((int) (Math.random() * sumArea) < area) selected = rect;
        }
        int x = (int) (Math.random() * (selected[2] - selected[0] + 1)) + selected[0];
        int y = (int) (Math.random() * (selected[3] - selected[1] + 1)) + selected[1];
        
        return new int[]{x, y};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */