package com.solutions.neetcode.dp.LC673;

public class NumberOfLongestIncreasingSubsequence {

    class Solution {
        public int findNumberOfLIS(int[] nums) {

            int [] dp = new int[nums.length];
            int [] count = new int[nums.length];
            int longestSubsequence = 0;

            for(int i = nums.length - 1; i >= 0; i--) {
                int max = 0;
                int countOfMax = 0;
                for(int j = i + 1; j < nums.length; j++) {
                    if(nums[j] > nums[i]) {
                        if(dp[j] > max) {
                            max = dp[j];
                            countOfMax = count[j];
                        }
                        else if(max == dp[j]) {
                            countOfMax+=count[j];
                        }
                    }
                }

                dp[i] = max + 1;
                count[i] = countOfMax == 0? 1:countOfMax;
                if(dp[i] > longestSubsequence) longestSubsequence = dp[i];
            }

            int totalCount = 0;
            for(int i = 0; i < nums.length; i++) {
                if(dp[i] == longestSubsequence) {
                    totalCount+=count[i];
                }
            }

            return totalCount;
        }
    }

}
