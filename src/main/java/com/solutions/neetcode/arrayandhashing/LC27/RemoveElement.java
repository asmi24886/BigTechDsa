package com.solutions.neetcode.arrayandhashing.LC27;

public class RemoveElement {
    class Solution {

        public int removeElement(int[] nums, int val) {
            int start =0;
            int end = nums.length - 1;

            while(start <= end) {
                if(nums[start] == val) {
                    nums[start] = nums[end];
                    end--;
                }
                else {
                    start++;
                }
            }
            return start;
        }

        public int removeElement2(int[] nums, int val) {

            int start = 0;
            int end = nums.length-1;

            if(val > 50)
                return nums.length;

            while( start <= end) {

                if(nums[start] != val) {
                    start++;
                    continue;
                }

                while(end > start && nums[end] == val) {
                    end--;
                }

                if(start == end)
                    return start;

                nums[start] = nums[end];
                nums[end] = val;

                start++;

            }

            return start;
        }
    }
}
