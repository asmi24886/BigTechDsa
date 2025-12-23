package com.solutions.neetcode.backtracking.LC51;

import java.util.*;

public class NQueens {

    class Solution {
        HashMap<Integer, int []> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        char [][] mem;
        int N;

        public List<List<String>> solveNQueens(int n) {
            N=n;
            mem = new char [n][n];
            for(int i = 0; i < n; i++) {
                Arrays.fill(mem[i], '.');
            }
            helper(0);
            return res;
        }

        void helper(int row) {
            if(row == N) {
                processResult();
                return;
            }

            for(int col = 0; col < N; col++) {
                if(canPlace(row, col)) {

                    map.put(row, new int [] {row, col});
                    mem[row][col] = 'Q';

                    helper(row+1);

                    mem[row][col] = '.';
                    map.remove(row);
                }
            }
        }

        boolean canPlace(int x, int y) {
            Collection<int[]> v = map.values();
            for(int [] p : v) {
                double s = slope(p[0], p[1], x, y);
                if(s == 0.0 || s == 1.0) return false; //vertical or diagonal
            }
            return true;
        }

        double slope(int x1, int y1, int x2, int y2) {
            return Math.abs((double)(y2-y1)/(x2-x1));
        }

        void processResult() {
            List<String> list = new ArrayList<>();
            for(int i = 0; i < N; i++) {
                list.add(new String(mem[i]));
            }

            res.add(list);
        }
    }
}
