package com.solutions.neetcode.backtracking.LC40;

import java.util.;
//TODO optimize
public class CombinationSum2 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int [] candidates = {10,1,2,7,6,1,5};
        sol.combinationSum2(candidates, 8).forEach(
                System.out::println
        );
    }



    static class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(candidates);
            backtrack(candidates, target, result, new ArrayList<>(), 0, 0);
            return result.stream().toList();
        }

        public void backtrack(int [] candidates, int target, List<List<Integer>> result,
                             ArrayList<Integer> solution, int currentSum, int index) {

            if(currentSum == target) {
                result.add(new ArrayList<>(solution));
                return;
            }

            if(index >= candidates.length) {
                return;
            }

            solution.add(candidates[index]);
            backtrack(candidates, target, result, solution, currentSum + candidates[index], index + 1);
            solution.remove(solution.size() - 1);

            while(index + 1 < candidates.length && candidates[index] == candidates[index + 1] ) index++;
            backtrack(candidates, target, result, solution, currentSum, index + 1);
        }
    }



}
