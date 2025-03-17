package com.solutions.neetcode.backtracking.LC39;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {

        Solution solution = new Solution();

        int [] nums1 = {2,3,6,7};
        int [] nums2 = {2,3,5};
        int [] nums3 = {2};
        solution.combinationSum(nums1, 7).forEach(System.out::println);
        System.out.println("============================================");
        solution.combinationSum(nums2, 8).forEach(System.out::println);
        System.out.println("============================================");
        solution.combinationSum(nums3, 1).forEach(System.out::println);
    }
    static class Solution {
        public List<List<Integer>> combinationSum(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            if(nums.length == 0) return result;

            backtrack(0, nums, new ArrayList<>(), result, 0, target);

            return result;
        }

        public void backtrack(int idx, int [] nums, List<Integer> solution, List<List<Integer>> result, int currentSum, int target) {
            if(currentSum == target) {
                result.add(new ArrayList<>(solution));
                return;
            }
            else if(currentSum > target || idx == nums.length) {
                return;
            }

            solution.add(nums[idx]);
            backtrack(idx, nums, solution, result, currentSum + nums[idx], target);

            solution.removeLast();
            backtrack(idx+1, nums, solution, result, currentSum, target);
        }
    }
}
