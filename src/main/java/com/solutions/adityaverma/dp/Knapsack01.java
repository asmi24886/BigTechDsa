package com.solutions.adityaverma.dp;


//Maximum profits
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
    }

    public static void main(String [] args) {
        Solution solution = new Solution();
        System.out.println(solution.max_profit_2d());

    }
}
