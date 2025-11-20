package com.solutions.neetcode.backtracking.LC47;

import java.util.*;

//Alternate solution - https://www.youtube.com/watch?v=qhBVWf0YafA
public class Permutations2 {

    public static void main (String [] args) {
        Solution sol = new Solution();
        int[] nums = {3, 0, 3, 3};
        sol.permuteUnique(nums).forEach(System.out::println);
    }

    static class Solution {

        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            boolean [] visited = new boolean[nums.length];
            backtrack(nums, new ArrayList<>(), visited);
            return result;
        }

        public void backtrack(int[] nums, List<Integer> sol, boolean [] visited) {

            if(sol.size() == nums.length) {
                result.add(new ArrayList<>(sol));
                return;
            }

            for(int i = 0; i < nums.length; i++) {

                if(visited[i]) continue;

                int j = i+1;
                while(j < nums.length && nums[j] == nums[i]) {
                    if(visited[j++]) return;
                }
                sol.add(nums[i]);
                visited[i] = true;
                backtrack(nums, sol, visited);
                visited[i] = false;
                sol.remove(sol.size() - 1);
            }
        }
    }
}
