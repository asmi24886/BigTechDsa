package com.solutions.neetcode.dp.LC5;

import com.google.gson.Gson;

public class LongestPalindromicSubstring {

    class Solution {
        public String longestPalindrome(String s) {
            //babd

            boolean [][] dp = new boolean [s.length()][s.length()];
            int [] max = new int[] {0,0}; //i,j,length

            for(int k = 0; k < s.length(); k++) {
                for(int i = 0; i < s.length() - k; i++) {
                    int j = i + k;

                    if(s.charAt(i) == s.charAt(j)) {
                        if(i == j || j-i == 1 || dp[i+1][j-1]) {
                            dp[i][j] = true;
                            max = (max[1] - max[0]) < j - i ? new int[] {i, j} : max;
                        }
                    }
                }
            }

            return s.substring(max[0], max[1]+1);
        }
    }
}
