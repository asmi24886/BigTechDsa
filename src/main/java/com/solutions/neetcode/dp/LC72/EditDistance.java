package com.solutions.neetcode.dp.LC72;

public class EditDistance {

    class Solution {
        public int minDistance(String word1, String word2) {

            if(word1.isEmpty()) return word2.length();
            if(word2.isEmpty()) return word1.length();

            int m = word1.length();
            int n = word2.length();
            int [][] dp = new int [m+1][n+1];

            dp[0][0] = 0;

            for(int i = 1; i <= m; i++) {
                dp[i][0] = i;
            }

            for(int j = 1; j <= n; j++) {
                dp[0][j] = j;
            }

            /*
                consider -

                word1 => ab
                word2 => ac

                draw the matrix ->

                0 1 2
                1 0 2
                2 2 1 ---> (comes from [1,1])
             */
            for(int i = 1; i <= m; i++) {

                for(int j = 1; j <= n; j++) {

                    if(word1.charAt(i-1) == word2.charAt(j-1)) {
                        dp[i][j] = dp[i-1][j-1];
                        continue;
                    }

                    //Add, Delete, Replace
                    // could be space optimized with prev and curr, but do not optimize unless asked. Kept for revision
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                }
            }
            return dp[m][n];

        }
    }
}
