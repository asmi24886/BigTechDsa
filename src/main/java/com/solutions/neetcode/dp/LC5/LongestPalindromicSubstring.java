package com.solutions.neetcode.dp.LC5;

public class LongestPalindromicSubstring {

    class Solution {
        public String longestPalindrome(String s) {
            //babd
            return twoPointers(s);
        }

        public String twoPointers(String s) {

            int [] max = new int[]{0,0};
            for(int c = 0; c < s.length(); c++) {
                int i= c, j = c;

                int [] arr = twoPointersCompute(i, j, s);
                max = (max[1] - max[0]) < (arr[1] - arr[0]) ? arr : max;

                i= c; j = c+1;
                arr = twoPointersCompute(i, j, s);
                max = (max[1] - max[0]) < (arr[1] - arr[0]) ? arr : max;
            }

            return s.substring(max[0], max[1]+1);
        }

        private int [] twoPointersCompute(int i, int j, String s) {
            int [] arr = new int [] {0, 0};
            while( i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
                arr[0] = i;
                arr[1] = j;
                i--;
                j++;
            }

            return arr;
        }

        String dp(String s) {
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
