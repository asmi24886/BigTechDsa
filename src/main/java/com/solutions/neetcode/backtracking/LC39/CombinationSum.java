package com.solutions.neetcode.backtracking.LC39;

import java.util.*;

public class CombinationSum {
    class Solution {
        public List<List<Integer>> combinationSum(int[] nums, int target) {
            return backtrack(nums, target, 0, new ArrayList<>(), 0, new ArrayList<>());
        }

        private List<List<Integer>> backtrack(
                int [] nums,
                int target,
                int i,
                List<Integer> path,
                int sum,
                List<List<Integer>> result
        ) {

            if(sum == target) {
                result.add(new ArrayList<>(path));
                return result;
            }

            if(i == nums.length || sum > target) {
                return result;
            }

            for(int j = i; j < nums.length; j++) {

                path.add(nums[j]);
                backtrack(nums, target, j, path, sum+nums[j], result);
                path.removeLast();
            }

            return result;
        }
    }
}