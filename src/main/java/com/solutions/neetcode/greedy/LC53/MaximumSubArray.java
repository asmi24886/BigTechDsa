package com.solutions.neetcode.greedy.LC53;

public class MaximumSubArray {

    class Solution {
        public int maxSubArray(int[] nums) {

            int maxSum = nums[0];
            int globalMax = nums[0];

            if(nums.length == 1) return maxSum;

            for(int i = 1; i < nums.length; i++) {
                int tempSum = maxSum + nums[i];
                if(tempSum < nums[i]) {
                    maxSum = nums[i];
                }
                else {
                    maxSum = tempSum;
                }

                if(maxSum > globalMax)
                    globalMax = maxSum;
            }

            return globalMax;
        }
    }

    //Kadane's algo vvv imp
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, current_sum = 0;

        for(int i=0;i<nums.length;i++){
            current_sum += nums[i];
            max = Math.max(current_sum,max);
            if(current_sum<0) current_sum = 0;
        }

        return max;
    }
}
