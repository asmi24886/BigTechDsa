package com.solutions.neetcode.math.LC50;

public class PowXN {
    class Solution {
        public double myPow(double x, int n) {

            if(n == 0) return 1;
            if(n == 1) return x;
            if(n == -1) return 1/x;
            if(x == 1) return 1;
            if(x == 0) return 0;

            long pow = Math.abs((long)n);

            double result = 1;
            while(pow > 0) {

                if( (pow & 1) == 1) {
                    result*=x;
                }

                x*=x;
                pow >>= 1;
            }

            return (n < 0) ? 1.0/result : result;

        }
    }
}
