package com.solutions.adityaverma.dp.partition;

import java.util.Arrays;

public class MatrixChainMultiplication {

    public static void main(String[] args) {
        new Solution().findMinimumOperations();
    }
    public static class Solution {

        public void findMinimumOperations() {
            int [] chain = {2, 1, 3, 4};

            System.out.println(findMinimumOperationsTabular(chain));
        }

        public int findMinimumOperationsTabular(int [] chain) {

            int [][] dp = new int [chain.length][chain.length];

            for(int chain_length = 2; chain_length < chain.length; chain_length++) {

                for(int index_left = 1; index_left <= chain.length - chain_length; index_left++) {

                    int index_right = index_left + chain_length - 1;

                    // This line will never execute due to the 2nd for loop check
                    // if(index_right >= chain.length) continue;

                    dp[index_left][index_right] = Integer.MAX_VALUE;

                    for(int partition_index = index_left; partition_index < index_right; partition_index++) {
                        dp[index_left][index_right] = Math.min(
                                dp[index_left][index_right],
                                chain[index_left-1]*chain[partition_index]*chain[index_right]
                                + dp[index_left][partition_index] + dp[partition_index+1][index_right]
                        );
                    }

                }

            }


            Arrays.stream(dp).forEach(arr -> System.out.println(Arrays.stream(arr).boxed().toList()));
            return dp[1][chain.length-1];
        }

    }
}
