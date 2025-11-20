package com.solutions.neetcode.dp.LC1049;

import java.util.Arrays;

public class LastStoneWeight2 {

    class Solution {
        public int lastStoneWeightII(int[] stones) {
            int totalSum = Arrays.stream(stones).sum();
            int targetSum = totalSum/2;
            boolean [] dp = new boolean [targetSum + 1];
            dp[0] = true;
            for(int i = 1; i <= stones.length; i++) {

                for(int j = targetSum; j >= stones[i-1]; j--) {
                    dp[j] = dp[j] || dp[j - stones[i - 1]];
                }
            }

            int maxSumAchieved = 0;

            for(int i = 0; i < dp.length; i++) {
                if(dp[i]) {
                    maxSumAchieved = i;
                }
            }

            return (totalSum - maxSumAchieved) - maxSumAchieved; //sum - 2  maxTargetSum

        }
    }
}
