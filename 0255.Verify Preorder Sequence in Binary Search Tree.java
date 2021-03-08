class Solution {
    /*
        Preorder of binary search is mid, small, big. So we push element to stack until
        the minimum value, once current value is larger than peek of stack, we have reached
        the right child of this value, and then we need to pop the stack until upper level
        because right child will be larger than its root, so the first element that larger
        than this element must be root of upper level and all upcoming element in preorder
        must be larger than current lowest value.
        O(n).
    */
    public boolean verifyPreorder(int[] preorder) {
        if (preorder.length == 0) return true;
        
        Stack<Integer> stack = new Stack<>();
        int low = Integer.MIN_VALUE;
        
        for (int a : preorder) {
            if (a < low) return false;
            // pop stack until upper level
            while (!stack.isEmpty() && a > stack.peek()) {
                low = stack.pop();
            }
            stack.push(a);
        }
        
        return true;
    }
}