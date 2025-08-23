package com.solutions.algomaster.dp.LC132;

public class PalindromePartitioning2 {
    //Recursive solution also present com.solutions.adityaverma.dp.partition.PalindromePartitioning2Recursive
    class Solution {

        public int minCut(String str) {

            if(str.isBlank() || new StringBuffer(str).reverse().toString().equals(str)) {
                return 0;
            }

            char [] arr = str.toCharArray();
            boolean [][] palindromeCache = new boolean [arr.length][arr.length];
            int [] partitionDp = new int[arr.length];

            buildPalindromeCache(arr, palindromeCache);
            minPartition(arr, partitionDp, palindromeCache);
            return partitionDp[partitionDp.length - 1];
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

        public void minPartition(char [] arr, int [] dp, boolean [][] palindromeCache) {

            for(int i = 0; i < arr.length; i++) {

                if(palindromeCache[0][i]) dp[i] = 0;
                else {
                    dp[i] = arr.length;
                    for(int j = 1; j <= i; j++) {
                        if(palindromeCache[j][i]) {
                            dp[i] = Math.min(dp[i], dp[j-1] + 1);
                        }
                    }
                }
            }
        }

    }
}
