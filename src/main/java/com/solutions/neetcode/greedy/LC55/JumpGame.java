package com.solutions.neetcode.greedy.LC55;

public class JumpGame {
    class Solution {
        public boolean canJump(int[] nums) {

            int last_jumpable_index = nums.length-1;
            for(int i = last_jumpable_index-1; i >=0; i--) {
                if(i+nums[i] >= last_jumpable_index) {
                    last_jumpable_index = i;
                }
            }

            return last_jumpable_index == 0;
        }
    }
}
