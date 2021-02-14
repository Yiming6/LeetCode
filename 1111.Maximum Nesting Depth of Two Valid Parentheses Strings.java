class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int biggestDepth = findBiggestDepth(seq);
        int leftCounter = 0;
        int rightCounter = 0;

        int n = seq.length();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (seq.charAt(i) == '(') {
                if (leftCounter < biggestDepth) {
                    leftCounter++;
                    result[i] = 0;
                } else {
                    rightCounter++;
                    result[i] = 1;
                }
            } else {
                if (rightCounter == 0) {
                    leftCounter--;
                    result[i] = 0;
                } else {
                    rightCounter--;
                    result[i] = 1;
                }
            }
        }
        
        return result;
    }
    
    private int findBiggestDepth(String seq) {
        int biggestDepth = 0;
        int depth = 0;
        
        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == '(') {
                depth++;
            } else {
                depth--;
            }
            
            biggestDepth = Math.max(biggestDepth, depth);
        }
        
        return (biggestDepth + 1) / 2;
    }
}