package com.solutions.adityaverma.dp.string;

public class LongestCommonSubstring {

    public static void main (String [] args) {

        Solution sol = new Solution();
        System.out.println(sol.longestCommonSubstring("abcde", "fabthcdek"));
    }

    static class Solution {

        public int longestCommonSubstring(String s1, String s2) {

            int [][] dp = new int[s1.length()+1][s2.length()+1];
            int longestUntilNow = 0;
            String longestString = "";
            StringBuilder currentString = new StringBuilder();
            for(int i = 1; i <= s1.length(); i++) {
                for(int j = 1; j <= s2.length(); j++) {
                    if(s1.charAt(i-1) == s2.charAt(j-1)) {

                        if(dp[i-1][j-1] == 0) {
                            currentString = new StringBuilder();
                        }

                        dp[i][j] = dp[i-1][j-1] + 1;
                        longestUntilNow = Math.max(longestUntilNow, dp[i][j]);

                        currentString.append(s1.charAt(i - 1));
                        if(currentString.length() > longestString.length()) longestString = currentString.toString();
                    }
                }
            }

            System.out.println(longestString);
            return longestUntilNow;
        }
    }
}
