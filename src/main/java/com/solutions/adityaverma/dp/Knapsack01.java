package com.solutions.adityaverma.dp;


import java.util.Arrays;
import java.util.stream.IntStream;//Maximum profits
import java.util.stream.Stream;

public class Knapsack01 {

    static class Solution {

        int [] profits = {3, 6, 5};
        int [] weights = {4, 5, 1};
        int W = 5;

        public int max_profit_2d() {
            int dp_i = profits.length + 1;
            int dp_j = W + 1;
            int [][] dp = new int [dp_i][dp_j];

            for(int i=0; i<dp_i; i++) {
                for(int j=0; j<dp_j; j++) {
                    if(i == 0 || j == 0) {
                        dp[i][j] = 0;
                        continue;
                    }

                    int include_not = dp[i-1][j];
                    if(weights[i-1] > j) {
                        dp[i][j] = include_not;
                        continue;
                    }

                    int include = profits[i-1] + dp[i-1][j - weights[i-1]];
                    dp[i][j] = Math.max(include, include_not);
                }
            }

            return dp[dp_i - 1][dp_j - 1];
        }

        public int max_profit_2_arrays() {
            int dp_i = profits.length + 1;
            int dp_j = W + 1;
            int [] dp_previous = IntStream.generate(() -> 0).limit(dp_j).toArray();
            int [] dp_current = IntStream.generate(() -> 0).limit(dp_j).toArray();

            for(int i=1; i<dp_i; i++) {
                for(int j=0; j<dp_j; j++) {

                    int include_not = dp_previous[j];
                    if(weights[i-1] > j) {
                        dp_current[j] = include_not;
                        continue;
                    }

                    int include = profits[i-1] + dp_previous[j - weights[i-1]];
                    dp_current[j] = Math.max(include, include_not);
                }

                // Just swap references, no need to reset values
                int[] temp = dp_previous;
                dp_previous = dp_current;
                dp_current = temp;
            }

            return dp_previous[dp_j - 1];
        }

        public int max_profit_optimized() {
            int dp_i = profits.length + 1;
            int dp_j = W + 1;

            int [] dp_current = IntStream.generate(() -> 0).limit(dp_j).toArray();

            for(int i=1; i<dp_i; i++) {
                for(int j=dp_j - 1; j>=weights[i - 1]; j--) {

                    int include = profits[i-1] + dp_current[j - weights[i-1]];
                    if(include > dp_current[j])
                        dp_current[j] = include;
                }
            }

            return dp_current[dp_j - 1];
        }
    }


    public static void main(String [] args) {
        Solution solution = new Solution();
        System.out.println(solution.max_profit_2d());
        System.out.println(solution.max_profit_2_arrays());
        System.out.println(solution.max_profit_optimized());

    }
}
