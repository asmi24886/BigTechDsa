package com.solutions.neetcode.graph.LC994;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottingOranges {

    /
            [
            [2,1,1],
            [1,1,1],
            [0,1,2]
            ]
     /
    class Solution {
        Queue<int []> queue = new LinkedList<>();
        List<int []> list = new LinkedList<>();

        public int orangesRotting(int[][] grid) {

            for(int i = 0; i < grid.length; i++) {

                for(int j = 0; j < grid[0].length; j++) {

                    if(grid[i][j] == 2) {
                        grid[i][j] = -2;
                        queue.offer(new int [] {i, j});
                    }
                    else if (grid[i][j] == 1) {
                        list.add(new int [] {i, j});
                    }
                }
            }

            if(list.isEmpty()) return 0;

            int time = bfs(grid);

            for(int i = 0; i < list.size(); i++) {
                if(grid[list.get(i)[0]][list.get(i)[1]] == 1) return -1;
            }

            return time;
        }

        private int bfs(int[][] grid) {
            int minutes = -1;

            while(!queue.isEmpty()) {
                int size = queue.size();
                minutes++;

                for(int k = 0; k < size; k ++) {
                    int [] cell = queue.poll();
                    int i = cell[0]; int j = cell[1];

                    int left = j - 1 >= 0 ? grid[i][j - 1] : 0;
                    if(left == 1)
                    {
                        queue.offer(new int[] {i,  j - 1});
                        grid[i][j - 1] = -2;
                    }

                    int right = j + 1 < grid[0].length ? grid[i][j + 1] : 0;
                    if(right == 1)
                    {
                        queue.offer(new int[] {i,  j + 1});
                        grid[i][j + 1] = -2;
                    }
                    int up = i - 1 >= 0 ? grid[i - 1][j] : 0;
                    if(up == 1)
                    {
                        queue.offer(new int[] {i - 1,  j});
                        grid[i - 1][j] = -2;
                    }
                    int down = i + 1 < grid.length ? grid[i + 1][j] : 0;
                    if(down == 1)
                    {
                        queue.offer(new int[] {i + 1,  j});
                        grid[i + 1][j] = -2;
                    }
                }
            }

            return minutes;
        }
    }
}
