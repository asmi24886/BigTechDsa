package com.solutions.neetcode.dp.LC279;

import java.util.Arrays;

public class PerfectSquares {
    class Solution {
        public int numSquares(int n) {

            int x = (int) Math.sqrt(n);
            int [] dp = new int[n+1];

            Arrays.fill(dp, n+1);
            dp[0] = 0;

            for(int i = 1; i <= x; i++) {

                for(int j = i*i; j<=n; j++) {

                    dp[j] = Math.min(dp[j - i*i] + 1, dp[j]);
                }
            }

            return dp[dp.length - 1];
        }
    }
}

//5
//
//0 - 0 6 6
//1 - 0
//2 -