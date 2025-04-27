package com.solutions.neetcode.dp.LC213;

public class HouseRobber2 {

    class Solution {
        public int rob(int[] nums) {
            if(nums.length == 1) return nums[0];

            int [] dp = new int [nums.length+1];

            dp[0] = 0;
            dp[1] = nums[0];

            for(int i = 2; i < nums.length;i++) {
                dp[i] = Math.max(nums[i-1] + dp[i - 2], dp[i - 1]);
            }

            int maxFirstPass = dp[dp.length - 2];

            dp[1] = 0;
            dp[2] = nums[1];

            for(int i = 3; i <= nums.length;i++) {
                dp[i] = Math.max(nums[i-1] + dp[i - 2], dp[i - 1]);
            }

            return Math.max(dp[dp.length - 1], maxFirstPass);
        }
    }
}
