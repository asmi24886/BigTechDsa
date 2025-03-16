package com.solutions.neetcode.backtracking.LC78;

import java.util.ArrayList;
import java.util.List;

public class Subset {

    public static void main(String [] args) {
        SolutionBacktrack sol = new SolutionBacktrack();
        int [] nums = {1,2,3};
        List<List<Integer>> result = sol.subsets(nums);
        result.forEach(System.out::println);
    }

    static class SolutionBacktrack {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            if(nums.length == 0) return result;

            constructSubset(0, nums, new ArrayList<>(), result);

            return result;
        }

        public void constructSubset(int idx, int [] nums, List<Integer> solution, List<List<Integer>> result) {
            if(idx == nums.length) {
                result.add(new ArrayList<>(solution));
                return;
            }

            solution.add(nums[idx]);
            constructSubset(idx+1, nums, solution, result);

            solution.removeLast();
            constructSubset(idx+1, nums, solution, result);
        }
    }

    static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            if(nums.length == 0) return result;

            for(int i = 0; i < nums.length; i++) {
                constructSubset(nums[i], result);
            }
            return result;
        }

        public void constructSubset(int num, List<List<Integer>> result) {
            int size = result.size();
            for(int i = 0; i < size; i++) {
                List<Integer> tempList = new ArrayList<>(result.get(i));
                tempList.add(num);
                result.add(tempList);
            }
        }
    }
}
