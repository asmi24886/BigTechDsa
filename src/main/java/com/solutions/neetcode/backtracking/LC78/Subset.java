package com.solutions.neetcode.backtracking.LC78;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            return backtrack(nums, 0, new ArrayList<>(), new ArrayList<>());
        }

        private List<List<Integer>> backtrack(int [] nums, int i, List<Integer> path, List<List<Integer>> res) {
            res.add(new ArrayList<>(path));

            for(int j = i; j < nums.length; j++) {
                path.add(nums[j]);
                backtrack(nums, j+1, path, res);
                path.removeLast();
            }

            return res;
        }

        void backtrack2(int[] nums, int i, List<Integer> path, List<List<Integer>> res) {
            if (i == nums.length) {              // base case: decided for every element
                res.add(new ArrayList<>(path));
                return;
            }

            // Choice 1: DON'T take nums[i]
            backtrack(nums, i + 1, path, res);

            // Choice 2: TAKE nums[i]
            path.add(nums[i]);
            backtrack(nums, i + 1, path, res);
            path.remove(path.size() - 1);        // undo
        }
    }

}
