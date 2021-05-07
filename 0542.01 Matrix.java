class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if (mat.length == 0 || mat[0].length == 0) return new int[0][0];
        
        int m = mat.length, n = mat[0].length;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) queue.add(new Pair<>(i, j));
                else mat[i][j] = Integer.MAX_VALUE;
            }
        }
        
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> curr = queue.poll();
            
            for (int[] dir : dirs) {
                int y = curr.getKey() + dir[0], x = curr.getValue() + dir[1];
                
                if (y >= 0 && y < m && x >= 0 && x < n && mat[y][x] > mat[curr.getKey()][curr.getValue()] + 1) {
                    mat[y][x] = mat[curr.getKey()][curr.getValue()] + 1;
                    queue.add(new Pair<>(y, x));
                }
                
            }
        }
        
        return mat;
    }
}