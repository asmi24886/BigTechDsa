package com.solutions.neetcode.dp.LC312;

//1,[3,1,5,8],1
// MCM / Interval DP ->
/*
    PATTERN
    ---------------------

    dp[l][r] =
    best over all i in (l, r) of
    dp[l][i] + dp[i][r] + cost(l, i, r)

 */
public class BurstBalloons {
    class Solution {
        public int maxCoins(int[] nums) {

            int n = nums.length;
            int N = n+2;
            int[] newNums = new int[N];
            newNums[0] = newNums[N-1] = 1;

            for (int i = 0; i < n; i++) {
                newNums[i + 1] = nums[i];
            }

            int[][] dp = new int[N][N];


            // len = gap between boundaries
            for (int len = 2; len < N; len++) {
                for (int l = 0; l + len < N; l++) {
                    int r = l + len;

                    for (int i = l + 1; i < r; i++) {
                        dp[l][r] = Math.max(
                                dp[l][r],
                                dp[l][i] + dp[i][r]
                                        + newNums[l] * newNums[i] * newNums[r]
                        );
                    }
                }
            }

            return dp[0][N-1];
        }
    }
}
