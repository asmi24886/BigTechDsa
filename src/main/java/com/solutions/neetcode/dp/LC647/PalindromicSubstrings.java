package com.solutions.neetcode.dp.LC647;

public class PalindromicSubstrings {
    class Solution {
        public int countSubstrings(String s) {
            return twoPointers(s);
        }

        public int twoPointers(String s) {
            //abadd
            int max = 0;
            for(int c = 0; c < s.length(); c++) {
                int i= c, j = c;

                int c1 = twoPointersCompute(i, j, s);

                i= c; j = c+1;
                int c2 = twoPointersCompute(i, j, s);
                max += (c1 + c2);
            }

            return max;
        }

        private int twoPointersCompute(int i, int j, String s) {
            int count = 0;
            while( i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
                count++;
                i--;
                j++;
            }

            return count;
        }

        int dp(String s) {
            boolean [][] dp = new boolean[s.length()][s.length()];
            int max = 0;
            for(int k = 0; k < s.length(); k++) {

                for(int i = 0; i < s.length() - k; i++) {

                    int j = i+k;
                    if(s.charAt(i) == s.charAt(j)) {

                        int next_i = i+1;
                        int next_j = j-1;

                        if(next_i<=next_j) {
                            dp[i][j] = dp[next_i][next_j];
                        }
                        else {
                            dp[i][j] = true;
                        }

                        max = dp[i][j] ? max+1:max;
                    }
                }
            }

            return max;
        }
    }
}
