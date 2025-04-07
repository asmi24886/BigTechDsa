package com.solutions.adityaverma.dp.LC416;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

    class Solution {
        public boolean canPartition(int[] nums) {
            int totalSum = Arrays.stream(nums).reduce(0, Integer::sum);
            if(totalSum%2 != 0) return false;
            return hasSubsetSum(nums, totalSum/2);
        }

        public boolean hasSubsetSum(int[] nums, int target) {
            boolean [] dp = new boolean [target + 1];
            dp[0] = true;

            for(int dp_i = 1; dp_i <= nums.length; dp_i++) {
                for(int dp_j = target; dp_j >= nums[dp_i - 1]; dp_j--) {
                    dp[dp_j] = dp[dp_j] || dp[dp_j - nums[dp_i-1]];
                }
            }
            return dp[dp.length - 1];
        }
    }
}

