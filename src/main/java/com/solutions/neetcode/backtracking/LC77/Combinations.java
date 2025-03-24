package com.solutions.neetcode.backtracking.LC77;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static void main (String [] args) {
        Solution sol = new Solution();
        sol.combine(4, 2).forEach(
                System.out::println
        );
    }

    static class Solution {

        public List<List<Integer>> result = new ArrayList<>();
        public List<List<Integer>> combine(int n, int k) {
            backtrack(1, n, k, new ArrayList<>());
            return result;
        }

        public void backtrack(int cur, int n, int k, List<Integer> sol) {

            if(sol.size() == k) {
                result.add(new ArrayList<>(sol));
                return;
            }

            if(cur > n) return;

            for(int i = cur; i <= n; i++) {
                sol.add(i);
                backtrack(i+1, n, k, sol);
                sol.remove(sol.size() - 1);
            }
        }
    }
}
