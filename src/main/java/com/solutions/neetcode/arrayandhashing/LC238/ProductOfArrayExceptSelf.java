package com.solutions.neetcode.arrayandhashing.LC238;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String [] s) {
        Arrays.stream(new Solution().productExceptSelf(new int[]{-1,1,0,-3,3})).forEach(System.out::println);
    }
    static class Solution {
        public int[] productExceptSelf(int[] nums) {

            if(nums.length <= 1) return nums;

            int [] answer = new int[nums.length];
            int memo = 1;

            //backward pass
            for(int i = nums.length -1; i >= 0; i--) {
                if(i == nums.length - 1) {
                    answer[i] = 1;
                }
                else {
                    answer[i] = memo * answer[i+1];
                }
                memo = nums[i];
            }

            System.out.println(Arrays.stream(answer).boxed().toList());
            System.out.println(memo);
            //forward pass
            memo = nums[0];
            nums[0] = 1;
            for(int i = 0; i < nums.length; i++) {
                if(i > 0) {
                    nums[0] = memo * nums[i - 1];
                    memo = nums[i];
                    nums[i] = nums[0];
                }
            }
            System.out.println(Arrays.stream(nums).boxed().toList());
            for(int i = 1; i < nums.length; i++) {
                answer[i] = nums[i] * answer[i];
            }

            return answer;
        }
    }
}
