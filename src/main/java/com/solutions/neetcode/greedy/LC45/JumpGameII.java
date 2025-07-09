package com.solutions.neetcode.greedy.LC45;

import java.lang.reflect.Array;
import java.util.Arrays;

public class JumpGameII {

    class Solution {
        public int jump(int[] nums) {
            int endIndex = nums.length - 1;
            int closestSuccessIndex = endIndex;

            int[] minSteps = new int[nums.length];

            for(int i = endIndex - 1; i >=0; i--) {
                int minStep = Integer.MAX_VALUE;

                if(i + nums[i] >= closestSuccessIndex) {
                    closestSuccessIndex = i;

                    //Now find what will be the min step among all step choices from here
                    for(int k = i+1; k <=Math.min(endIndex, nums[i] + i); k++) {
                        minStep = Math.min(minStep, minSteps[k]);
                    }
                }
                else {
                    minSteps[i] = minStep;
                    continue;
                }

                minSteps[i] = 1 + minStep;
            }

            return minSteps[0];
        }


        public int jumpDp(int[] nums) {
            int endIndex = nums.length - 1;
            int [] dp = new int[nums.length];
            Arrays.fill(dp, Integer.MAX_VALUE - 1);
            dp[endIndex] = 0;
            for(int i = endIndex - 1; i >=0; i--) {
                for(int j = i+1; j <= Math.min(endIndex, nums[i] + i); j++) {
                    dp[i] = Math.min(dp[i], 1+dp[j]);
                }
            }
            return dp[0];
        }

        public int jumpGreedy(int[] nums) {
            if(nums.length == 1)
                return 0;

            int jumps = 0; int start = 1; int end = nums[0];

            while(end < nums.length - 1) {
                jumps++;
                int maxIndexReachable = -1;

                while(start <= end) {
                    if(nums[start] + start > maxIndexReachable) {
                        maxIndexReachable = nums[start] + start;
                    }
                }

                start = end+1;
                end = maxIndexReachable;
            }

            return jumps;
        }
    }

}
