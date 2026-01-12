package com.solutions.neetcode.dp.LC62;

public class UniquePaths {
    class Solution {
        public int uniquePaths(int m, int n) {
            return dp_1(m, n);
        }

        int dp_1(int m, int n) {
            int [] dp = new int [n];

            for(int i = 0; i < m; i++) {

                for(int j = 0; j < n; j++) {

                    if(i == 0 || j == 0) {
                        dp[j] = 1;
                        continue;
                    }

                    dp[j] = dp[j] + dp[j-1];
                }
            }

            return dp[n-1];
        }
    }
}
