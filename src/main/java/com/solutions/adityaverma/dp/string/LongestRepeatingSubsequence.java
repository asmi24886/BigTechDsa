package com.solutions.adityaverma.dp.string;

public class LongestRepeatingSubsequence {

    public static void main(String [] args) {
        System.out.println(new Solution().lrs("aabebcdd"));
    }

    public static class Solution {

        private int lrs(String s) {
            char [] chars = s.toCharArray();

            int [][] dp = new int[s.length() + 1][s.length()+1];

            for(int i = 1; i <= s.length(); i++) {
                for(int j = 1; j <= s.length(); j++) {

                    if(i != j && chars[i-1] == chars[j - 1]) {
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }
                    else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
            return dp[s.length()][s.length()];
        }
    }
}
