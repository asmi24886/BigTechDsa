package com.solutions.neetcode.graph.LC200;

public class NumberOfIslands {
    public static void main(String [] args) {
        Solution sol = new Solution();
        char [][] grid = {
                {'0','1','1','1','0'},
                {'0','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0',0}
          };

        System.out.println(sol.numIslands(grid));
    }

    static class Solution {
        public int numIslands(char[][] grid) {
            int connectedIslands = 0;
            for(int i = 0; i < grid.length; i++) {
                for(int j = 0; j < grid[0].length; j++) {
                    if(grid[i][j] == '1') {
                        connectedIslands++;
                        markConnected(grid, i, j);
                    }
                }
            }
            return connectedIslands;
        }

        private void markConnected(char[][] grid, int i, int j) {
            if(i < 0 || i == grid.length) return;
            if(j < 0 || j == grid[0].length) return;
            if(grid[i][j] == '0') return;

            //mark visited
            grid[i][j] = '0';

            //right
            markConnected(grid, i, j+1);
            //bottom
            markConnected(grid, i+1, j);
            //left
            markConnected(grid, i, j-1);
            //top
            markConnected(grid, i-1, j);

        }
    }

}
