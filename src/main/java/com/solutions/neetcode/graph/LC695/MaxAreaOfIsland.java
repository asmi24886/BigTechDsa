package com.solutions.neetcode.graph.LC695;

public class MaxAreaOfIsland {
    public static void main(String [] args) {
        Solution sol = new Solution();
        int [][] grid = {
        {0,0,1,0,0,0,0,1,0,0,0,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,1,1,0,1,0,0,0,0,0,0,0,0},
        {0,1,0,0,1,1,0,0,1,0,1,0,0},
        {0,1,0,0,1,1,0,0,1,1,1,0,0},
        {0,0,0,0,0,0,0,0,0,0,1,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };

        System.out.println(sol.maxAreaOfIsland(grid));
    }

    static class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            int maxIslandCount = 0;
            for(int i = 0; i < grid.length; i++) {
                for(int j = 0; j < grid[0].length; j++) {
                    if(grid[i][j] == 1) {
                        maxIslandCount = Math.max(maxIslandCount, countAndMarkConnected(grid, i, j));

                    }
                }
            }
            return maxIslandCount;
        }

        private int countAndMarkConnected(int[][] grid, int i, int j) {
            if(i < 0 || i == grid.length) return 0;
            if(j < 0 || j == grid[0].length) return 0;
            if(grid[i][j] == 0) return 0;

            //mark visited
            grid[i][j] = 0;

            return 1
                    //right
                    + countAndMarkConnected(grid, i, j+1)
                    //bottom
                    + countAndMarkConnected(grid, i+1, j)
                    //left
                    + countAndMarkConnected(grid, i, j-1)
                    //top
                    + countAndMarkConnected(grid, i-1, j);
        }
    }

}
