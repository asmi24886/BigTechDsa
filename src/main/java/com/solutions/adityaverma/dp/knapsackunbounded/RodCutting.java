package com.solutions.adityaverma.dp.knapsackunbounded;

/**
 * Techdose - https://www.youtube.com/watch?v=nYJDp0Hj7M4
 * Unbounded Knapsack
 */
public class RodCutting {

    public static void main(String [] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxProfit());
    }
    static class Solution {

        int L = 4;
        int [] cuts = {1,2,3,4};
        int [] profit = {1,5,8,9};

        public int maxProfit() {

            int [] dp = new int[L+1];

            for(int dp_i = 1; dp_i <= L; dp_i++) {

                for(int dp_j = cuts[dp_i - 1]; dp_j <= L; dp_j++) {
                    int include  = profit[dp_i-1] + dp[dp_j - cuts[dp_i - 1]];
                    dp[dp_j] = Math.max(dp[dp_j], include);
                }
            }
            return dp[dp.length - 1];
        }
    }
}
