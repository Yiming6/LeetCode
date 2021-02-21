class Solution {
    /*
        Recursion, Binary search. Note to handle the situation that n < 0.
        Note to convert integer n to long integer n in case of overflow.
    */
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        
        long N = (long) n;
        
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        
        double r = myPow(x, (int) (N / 2));
        if (n % 2 == 0) return r * r;
        else return r * r * x;
    }
}