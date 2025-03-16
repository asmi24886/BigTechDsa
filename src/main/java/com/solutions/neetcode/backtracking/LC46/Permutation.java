package com.solutions.neetcode.backtracking.LC46;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/permutations/description/
//https://www.youtube.com/watch?v=Nabbpl7y4Lo
public class Permutation {

    public static void main(String [] args) {
        Solution sol = new Solution();
        int [] nums = {1,2,3};
        List<List<Integer>> result = sol.permute(nums);
        result.forEach(System.out::println);
    }

    static class Solution {

        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if(nums.length == 0) return result;
            if(nums.length == 1) {
                result.add(List.of(nums[0]));
                return result;
            }
            backtrack(result, new LinkedList<>(), new boolean[nums.length], nums);
            return result;
        }

        //backtrack method (recursion)
        public void backtrack(
                List<List<Integer>> result,
                LinkedList<Integer> currentSolution,
                boolean [] visited,
                int [] nums
        ) {
            // 1. Ending condition
            if(currentSolution.size() == nums.length) {
                result.add(new LinkedList<>(currentSolution));
                return;
            }

            for(int i = 0; i < nums.length; i++) { //for each choice
                //Validation condition
                if(visited[i]) continue;

                //take action
                currentSolution.push(nums[i]);
                visited[i] = true;

                //Given this choice as parent call stack, take next choices
                backtrack(result, currentSolution, visited, nums);

                //Undo current choice and proceed with next loop for next choice for this call stack
                currentSolution.pop();
                visited[i] = false;
            }
        }
    }

    static class BruteForceSolution {
        int [] arr = {1,2,3};
        List<List<Integer>> result = new ArrayList<>();

        public void permutation() {
            result.add(new ArrayList<>());
            for(int num : arr) {
                doPermutation(num);
            }

            result.forEach(System.out::println);
        }

        public void doPermutation(int num) {

            List<List<Integer>> tempResults = new ArrayList<>();

            for(List<Integer> numList : result) {
                tempResults.addAll(permute(num, numList));
            }

            result = tempResults;
        }
        
        public List<List<Integer>> permute(int num, List<Integer> numList) {
            List<List<Integer>> tempResults = new ArrayList<>();

            for(int i = 0; i <= numList.size(); i++) {
                List<Integer> tempNumList = new ArrayList<>(numList);
                tempNumList.add(i, num);
                tempResults.add(tempNumList);
            }
            return tempResults;
        }
    }
}
