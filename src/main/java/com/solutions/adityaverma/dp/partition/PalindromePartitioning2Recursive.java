package com.solutions.adityaverma.dp.partition;

public class PalindromePartitioning2Recursive {

    public static void main(String[] args) {
        System.out.println(new Solution().minCut("ccdabafg"));
    }

    public static class Solution {

        public int minCut(String str) {

            if(str.isBlank() || new StringBuffer(str).reverse().toString().equals(str)) {
                return 0;
            }

            char [] arr = str.toCharArray();
            boolean [][] palindromeCache = new boolean [arr.length][arr.length];
            int [][] partitionDp = new int[arr.length][arr.length];

            initializeDpTable(partitionDp);
            buildPalindromeCache(arr, palindromeCache);
            return minPartition(0, arr.length - 1, arr, partitionDp, palindromeCache);
        }

        public void initializeDpTable(int [][] dp) {
            for (int i = 0; i < dp.length; i++) {
                for(int j = 0; j < dp.length; j++) {
                    dp[i][j] = -1;
                }
            }
        }
        public void buildPalindromeCache(char [] arr, boolean [][] palindromeDp) {

            for(int i = 0; i < arr.length; i++) {
                palindromeDp[i][i] = true;
            }

            for(int size = 2; size<=arr.length; size++) {

                for(int l = 0; l <= arr.length - size; l++) {

                    int r = l + size - 1;

                    if(arr[l] != arr[r]) continue;

                    if(size == 2 || palindromeDp[l+1][r-1])
                        palindromeDp[l][r] = true;
                }
            }
        }

        //Building the min dp table -> if j to i is palindrome then take the minimum of total number of partitions of rest of the string before palindrome + 1 and the current value stored for i
        public int minPartition(int l, int r, char [] arr, int [][] dp, boolean [][] palindromeCache) {

            if(l>=r) return 0;
            if(dp[l][r] != -1) return dp[l][r];
            if(palindromeCache[l][r]) return 0;

            int minCut = Integer.MAX_VALUE;
            for(int k = l; k < r; k++) {
                int minCutFromLeft = minPartition(l, k, arr, dp, palindromeCache);
                int minCutFromRight = minPartition(k+1, r, arr, dp, palindromeCache);
                minCut = Math.min(minCut, minCutFromLeft + minCutFromRight + 1);
            }

            dp[l][r] = minCut;
            return minCut;
        }

    }
}