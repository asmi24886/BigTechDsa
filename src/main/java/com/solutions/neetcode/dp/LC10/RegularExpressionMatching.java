package com.solutions.neetcode.dp.LC10;

public class RegularExpressionMatching {
    class Solution {
        public boolean isMatch(String s, String p) {

            // init
            boolean [][] dp = new boolean[s.length()+1][p.length()+1];
            dp[0][0] = true;
            for (int j = 2; j <= p.length(); j++) {
                if (p.charAt(j-1) == '*') {
                    dp[0][j] = dp[0][j-2];
                }
            }

            //solve
            for(int i = 1; i <= s.length(); i++) {
                for (int j=1; j <= p.length(); j++) {

                    char p_char = p.charAt(j-1);
                    char s_char = s.charAt(i-1);

                    if(p_char == '.' || p_char == s_char) {
                        dp[i][j] = dp[i-1][j-1];
                        continue;
                    }

                    // Special case - s = "a" and p = "a*a"
                    // |= is required
                    if(p_char == '*') {
                        dp[i][j] = dp[i][j-2]; //skip * regex of p and check if we can match
                        char prev_p_char = p.charAt(j-2);
                        if(prev_p_char == s_char || prev_p_char == '.') {
                            dp[i][j] |= dp[i-1][j];
                        }
                    }
                }
            }

            return dp[s.length()][p.length()];

        }

        //could also use two arrays
        public boolean isMatch_space_optimal(String s, String p) {

            // init
            boolean [] dp = new boolean[p.length()+1];
            dp[0] = true;
            for (int j = 2; j <= p.length(); j++) {
                if (p.charAt(j-1) == '*') {
                    dp[j] = dp[j-2];
                }
            }

            //solve
            for(int i = 1; i <= s.length(); i++) {
                boolean prev = dp[0];
                dp[0] = false;
                for (int j=1; j <= p.length(); j++) {
                    boolean temp = dp[j];
                    char p_char = p.charAt(j-1);
                    char s_char = s.charAt(i-1);

                    if(p_char == '.' || p_char == s_char) {
                        dp[j] = prev;
                    }
                    // Special case - s = "a" and p = "a*a"
                    // |= is required
                    else if(p_char == '*') {
                        dp[j] = dp[j-2]; //skip * regex of p and check if we can match
                        char prev_p_char = p.charAt(j-2);
                        if(prev_p_char == s_char || prev_p_char == '.') {
                            dp[j] |= temp;
                        }
                    }
                    else {
                        dp[j] = false;
                    }

                    prev = temp;
                }
            }

            return dp[p.length()];

        }
    }
}
