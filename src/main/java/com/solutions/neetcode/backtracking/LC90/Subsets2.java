package com.solutions.neetcode.backtracking.LC90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {

    public static void main (String [] args) {
        Solution sol = new Solution();
        int [] nums = {1,2,2};
        sol.subsetsWithDup(nums).forEach(
                System.out::println
        );
    }

    static class Solution {

        public List<List<Integer>> result = new ArrayList<>();
        public List<List<Integer>> subsetsWithDup(int [] nums) {
            Arrays.sort(nums);
            backtrack(0, nums, new ArrayList<>());
            return result;
        }

        public void backtrack(int index, int [] nums, List<Integer> sol) {

            result.add(new ArrayList<>(sol));

            if(index == nums.length) {
                return;
            }

            for(int i = index; i < nums.length; i++) {
                if(i > index && nums[i-1] == nums[i])
                    continue;

                sol.add(nums[i]);
                backtrack(i+1, nums, sol);
                sol.remove(sol.size() - 1);
            }
        }
    }
}

