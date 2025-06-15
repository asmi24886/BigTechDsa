package com.solutions.adityaverma.dp.partition.LC887;

public class SuperEggDrop {

    public static class Solution {

        public int[][] init(int k, int n) {
            int [][] dp = new int[k][n];
            for(int i = 1; i < k; i++) {
                for(int j = 1; j < n; j++) {

                    if(i == 1) {
                        dp[i][j] = j;
                        continue;
                    }

                    if(j == 1) {
                        dp[i][j] = 1;
                        continue;
                    }

                    dp[i][j] = -1;
                }
            }

            return dp;
        }

        public int minNumberOfMovesTabular(int no_of_eggs, int no_of_floors) {

            if(no_of_eggs == 1) return no_of_floors;
            if(no_of_floors == 1) return 1;

            int [][] dp = new int[no_of_eggs+1][no_of_floors+1];

            for(int eggs = 1; eggs < dp.length; eggs++) {
                for(int floors = 1; floors < dp[0].length; floors++) {

                    if(eggs == 1) {
                        dp[eggs][floors] = floors;
                        continue;
                    }

                    if(floors == 1) {
                        dp[eggs][floors] = 1;
                        continue;
                    }

                    int min = Integer.MAX_VALUE;

                    for(int k = 2; k <= floors; k++) {
                        min = Math.min( min, 1 + Math.max(dp[eggs - 1][k - 1], dp[eggs][floors - k]) );
                        dp[eggs][floors] = min;
                    }
                }
            }

            return  dp[dp.length - 1][dp[0].length-1];
        }

        public int superEggDrop(int k, int n) {
            return minNumberOfMoves(k, n, init(k+1, n+1));
        }

        public int minNumberOfMoves(int eggs, int floors, int [][] dp) {
            if(eggs == 1)
                return floors;

            if(floors == 0)
                return 0;

            if(floors == 1)
                return 1;

            if(dp[eggs][floors] != -1)
                return dp[eggs][floors];

            int min  = Integer.MAX_VALUE;
            for(int k = 2; k <= floors; k++) {
                int remaining_step_count_if_broken = minNumberOfMoves(eggs - 1, k - 1, dp);
                int remaining_step_count_if_not_broken = minNumberOfMoves(eggs, floors - k, dp);
                int worst_case = 1 + Math.max(remaining_step_count_if_broken, remaining_step_count_if_not_broken);

                min = Math.min(min, worst_case);
            }

            dp[eggs][floors] = min;
            return min;
        }
    }
}
