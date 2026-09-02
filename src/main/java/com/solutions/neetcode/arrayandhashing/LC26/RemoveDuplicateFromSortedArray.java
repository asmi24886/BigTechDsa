package com.solutions.neetcode.arrayandhashing.LC26;

public class RemoveDuplicateFromSortedArray {
    class Solution {
        public int removeDuplicates(int[] nums) {
            // 1, 2, 3, 3, 3, 4
            int gp = 0; int i = 0; int j = 0;

            while(j< nums.length) {

                if(j > 0 && nums[j-1] < nums[j]) {
                    i++;
                    nums[i] = nums[j];
                }

                j++;

            }

            return i+1;
        }
    }
}
