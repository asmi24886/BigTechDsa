package com.solutions.neetcode.arrayandhashing.LC217;

import java.util.HashMap;

// https://leetcode.com/problems/contains-duplicate/
public class ContainsDuplicate {

    public static void main(String[] args) {

    }

    public boolean containsDuplicate(int[] nums) {

        HashMap<Integer, Integer> counterMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            Integer count = counterMap.get(nums[i]);
            if(count == null) {
                counterMap.put(nums[i], 1);
            }
            else {
                return true;
            }
        }

        return false;
    }
}
