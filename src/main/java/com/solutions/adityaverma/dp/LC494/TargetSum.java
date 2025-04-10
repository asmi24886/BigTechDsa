package com.solutions.adityaverma.dp.LC494;

import java.util.Arrays;
import java.util.stream.IntStream;

public class TargetSum {

    public static void main(String []  args) {
        Solution sol = new Solution();
        int ans = sol.findTargetSumWays(IntStream.of(7,9,3,8,2,4,8,3,9).toArray(), 0);
        println(ans);
    }

    static void println(Object o) {
        System.out.println(o);
    }
    static class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            int sum = Arrays.stream(nums).sum();
            target = Math.abs(target);
            if(target > sum) return 0;
            if((sum - target) % 2 == 1) return 0;
            int targetSum = (sum - target)/2;

            return subsetSumCount(nums, targetSum);
        }

        private int subsetSumCount(int [] nums, int targetSum) {
            int[] dp = new int[targetSum + 1];
            dp[0] = 1;
            for(int dp_i = 1; dp_i <= nums.length; dp_i++) {
                for(int dp_j = targetSum; dp_j >= nums[dp_i - 1]; dp_j--) {
                    dp[dp_j] = dp[dp_j] + dp[dp_j - nums[dp_i - 1]];
                }
            }

            return dp[dp.length - 1];
        }
    }
}
