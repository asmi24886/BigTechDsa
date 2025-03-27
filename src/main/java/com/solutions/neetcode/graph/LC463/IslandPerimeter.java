package com.solutions.neetcode.graph.LC463;

public class IslandPerimeter {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int [][] grid = {
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}
        };
        System.out.println(sol.islandPerimeter(grid));
    }

    static class Solution {
        public int islandPerimeter(int[][] grid) {

            int cur_x = -1;
            int cur_y = -1;
            for(int i = 0; i < grid.length; i++) {
                for(int j = 0; j < grid[0].length; j++) {
                    if(grid[i][j]==1) {
                        cur_x = i;
                        cur_y = j;
                        break;
                    }
                }
            }

            return dfs(grid, cur_x, cur_y);
        }

        public int dfs(int[][] grid, int cur_x, int cur_y) {
            //Out of bounds
            if(cur_x < 0 || cur_x == grid.length)
                return 0;
            if(cur_y < 0 || cur_y == grid[0].length)
                return 0;

            //Water
            if(grid[cur_x][cur_y] == 0)
                return 0;

            //Visited
            if(grid[cur_x][cur_y] == -1)
                return 0;

            //Set grid visited
            grid[cur_x][cur_y] = -1;

            int top = dfs(grid, cur_x - 1, cur_y);
            int bottom = dfs(grid, cur_x + 1, cur_y);

            int left = dfs(grid, cur_x, cur_y - 1);
            int right = dfs(grid, cur_x, cur_y + 1);

            int adjacentPerimeter = top + bottom + left + right;

            return calculateOwnPerimeter(grid, cur_x, cur_y) + adjacentPerimeter;
        }

        private int calculateOwnPerimeter(int[][] grid, int curX, int curY) {
            int top = 0;
            int bottom = 0;
            int left = 0;
            int right = 0;

            //could have done with || operator but this is cleaner
            if(curX - 1 >= 0 && grid[curX - 1][curY] == 0) {
                top = 1;
            } else if(curX - 1< 0) {
                top = 1;
            }

            if(curX + 1 < grid.length && grid[curX + 1][curY] == 0) {
                bottom = 1;
            }
            else if( curX + 1 >= grid.length) {
                bottom = 1;
            }

            if(curY - 1 >=  0 && grid[curX][curY - 1] == 0) {
                left = 1;
            }
            else if(curY - 1 < 0) {
                left = 1;
            }

            if(curY + 1 < grid[0].length && grid[curX][curY + 1] == 0) {
                right = 1;
            }
            else if(curY + 1 >= grid[0].length) {
                right = 1;
            }

            return top + bottom + left + right;
        }
    }
}
