package com.solutions.adityaverma.dp.partition;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PalindromePartitioning {

    public static void main(String[] args) {
        new Solution().minCut("ab");
    }

    public static class Solution {

        public int minCut(String str) {

            if(str.isBlank() || new StringBuffer(str).reverse().toString().equals(str)) {
                return 0;
            }

            char [] arr = str.toCharArray();
            boolean [][] palindromeCache = new boolean [arr.length][arr.length];
            int [] partitionDp = new int[arr.length];

            buildPalindromeCache(arr, palindromeCache);
            minPartition(arr, partitionDp, palindromeCache);
//            System.out.println(Arrays.stream(palindromeCache).map(it -> IntStream.range(0, it.length).mapToObj(i -> it[i]).toList()).toList());
//            System.out.println(Arrays.stream(partitionDp).boxed().toList());
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

        //Building the min dp table -> if j to i is palindrome then take the minimum of total number of partitions of rest of the string before palindrome + 1 and the current value stored for i
        public void minPartition(char [] arr, int [] dp, boolean [][] palindromeCache) {

            for(int i = 0; i < arr.length; i++) {

                if(palindromeCache[0][i]) dp[i] = 0;
                else {
                    dp[i] = arr.length;
                    for(int j = 1; j <= i; j++) {
                        if(palindromeCache[j][i]) {
                            dp[i] = Math.min(dp[i], dp[j-1] + 1); // j-1 will be atleast 0 or 1 at some point because same character comparison is a palindrome so there must be a palindrome
                        }
                    }
                }
            }
        }

    }
}