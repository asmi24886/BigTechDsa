package com.solutions.neetcode.dp.LC115;

public class DistinctSubsequences {

    class Solution {
        public int numDistinct1(String s, String t) {

            int M = t.length();
            int N = s.length();

            int [][] dp = new int[M+1][N+1];

            for (int j = 0; j<=N; j++) {
                dp[M][j] = 1;
            }

            for(int i = M-1; i >= 0; i--) {

                for(int j = N - 1; j >= 0; j--) {

                    if(t.charAt(i) != s.charAt(j)) {
                        dp[i][j] = dp[i][j+1];
                        continue;
                    }

                    dp[i][j] = dp[i+1][j+1] + dp[i][j+1];
                }
            }

            return dp[0][0];
        }


        public int numDistinct(String s, String t) {

            int M = t.length();
            int N = s.length();

            int[] dp = new int[N + 1];

            // Base case: empty t
            for (int j = 0; j <= N; j++) {
                dp[j] = 1;
            }

            for (int i = M - 1; i >= 0; i--) {
                int prev = dp[N];  // dp[i+1][N] = 0
                dp[N] = 0;

                for (int j = N - 1; j >= 0; j--) {
                    int temp = dp[j];  // save dp[i+1][j]

                    if (t.charAt(i) != s.charAt(j)) {
                        dp[j] = dp[j + 1];
                    } else {
                        dp[j] = dp[j + 1] + prev;
                    }

                    prev = temp;  // move diagonal
                }
            }

            return dp[0];
        }
    }
}
