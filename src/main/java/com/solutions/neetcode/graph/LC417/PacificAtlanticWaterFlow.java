package com.solutions.neetcode.graph.LC417;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {

    /
            [
            [1,2,3],
            [8,9,4],
            [7,6,5]
            ]
     /
    class Solution {
        int [][] heights;
        boolean [][] result_p, result_a;
        int ROWS, COLS;
        int [][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // right, down, left, up <clock-wise>

        public List<List<Integer>> pacificAtlantic(int[][] h) {
            heights = h;
            ROWS = heights.length;
            COLS = heights[0].length;

            result_p = new boolean[ROWS][COLS];
            result_a = new boolean[ROWS][COLS];


            for(int i = 0; i < ROWS; i++) dfs(i, 0, result_p);
            for(int j = 0; j < COLS; j++) dfs(0, j, result_p);

            for(int i = 0; i < ROWS; i++) dfs(i, COLS - 1, result_a);
            for(int j = 0; j < COLS; j++) dfs(ROWS - 1, j, result_a);

            List<List<Integer>> list = new ArrayList<>();
            for(int i = 0; i < result_p.length; i++) {
                for(int j = 0; j < result_p[0].length; j++) {
                    if(result_p[i][j] && result_a[i][j]) {
                        list.add(List.of(i, j));
                    }
                }
            }

            return list;
        }

        void dfs(int i, int j, boolean [][] result) {
            result[i][j] = true;

            for(int [] d : directions) {

                int x  = i + d[0];
                int y = j + d[1];

                if(x < 0 || x == ROWS) continue;
                if(y < 0 || y == COLS) continue;
                if(result[x][y]) continue;
                if(heights[x][y] < heights[i][j]) continue;

                dfs(x,y,result);
            }

        }
    }
}
