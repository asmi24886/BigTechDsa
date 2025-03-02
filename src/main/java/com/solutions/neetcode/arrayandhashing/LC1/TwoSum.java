package com.solutions.neetcode.arrayandhashing.LC1;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {

    }

   static class Solution {
        public int[] twoSum(int[] nums, int target) {
             HashMap<Integer, Integer> map = new HashMap<>();

            for(int i=0; i<nums.length; i++) {
                Integer index = map.get(target - nums[i]);
                if(index != null)
                    return new int[]{index, i};

                map.put(nums[i], i);
            }
            return new int[]{};
        }
    }
}
