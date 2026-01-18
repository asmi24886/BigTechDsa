package com.solutions.neetcode.dp.LC97;

public class InterleavingString {
    //abc
    //def
    //abcdef
    class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            if (s1.length() + s2.length() != s3.length()) return false;
            int m = s1.length();
            int n = s2.length();
            boolean dp[][] = new boolean [m+1][n+1];

            dp[0][0] = true;

            for(int i = 1; i <= m; i++) {
                dp[i][0] = ( s3.charAt(i-1) == s1.charAt(i - 1) ) && dp[i-1][0];
            }

            for(int j = 1; j <= n; j++) {
                dp[0][j] = ( s3.charAt(j-1) == s2.charAt(j - 1) ) && dp[0][j-1];
            }

            for(int i = 1; i <= m; i++) {

                for(int j = 1; j <= n; j++) {

                    boolean match = false;
                    int k = i+j;
                    if(s3.charAt(k-1) == s1.charAt(i-1)) {
                        match = dp[i-1][j];
                    }

                    if(s3.charAt(k-1) == s2.charAt(j-1)) {
                        match |= dp[i][j-1];
                    }

                    dp[i][j] = match;
                }
            }

            return dp[m][n];
        }

    }


    class Solution1 {

        boolean[][] dp;
        Boolean[][] dp_;
        String s1, s2, s3;

        public boolean isInterleave(String s1, String s2, String s3) {
            if (s1.length() + s2.length() != s3.length()) return false;

            this.s1 = s1;
            this.s2 = s2;
            this.s3 = s3;

            dp = new boolean[s1.length() + 1][s2.length() + 1];
            dp_ = new Boolean[s1.length() + 1][s2.length() + 1];
            return dp1();
        }

        boolean dp1() {

            int m = s1.length();
            int n = s2.length();

            dp[m][n] = true;

            for (int j = n - 1; j >= 0; j--) {
                dp[m][j] = (s3.charAt(m + j) == s2.charAt(j)) && dp[m][j + 1];
            }

            for (int i = m - 1; i >= 0; i--) {
                dp[i][n] = (s3.charAt(n + i) == s1.charAt(i)) && dp[i + 1][n];
            }

            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {

                    boolean ok = false;

                    if (s3.charAt(i + j) == s1.charAt(i)) {
                        ok |= dp[i + 1][j];
                    }

                    if (s3.charAt(i + j) == s2.charAt(j)) {
                        ok |= dp[i][j + 1];
                    }

                    dp[i][j] = ok;
                }
            }

            return dp[0][0];
        }

        private boolean dfs(int i, int j) {
            if (i == s1.length() && j == s2.length())
                return true;

            if (dp_[i][j] != null)
                return dp[i][j];

            int k = i + j;
            boolean ok = false;

            if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
                ok |= dfs(i + 1, j);
            }

            if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
                ok |= dfs(i, j + 1);
            }

            return dp[i][j] = ok;
        }

    }

}
