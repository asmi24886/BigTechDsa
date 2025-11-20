package com.solutions.neetcode.graph.LC778;

import java.util.*;

public class SwimInRisingWater {

    class Solution {
        boolean[][] visited;
        PriorityQueue<int []> pq = new PriorityQueue<>(Comparator.comparing((int [] i) -> i[2]));
        List<int []> directions = List.of(
                new int[] {0, 1}, //right
                new int[] {1, 0}, //bottom
                new int[] {0, -1}, //left
                new int[] {-1, 0} //top
        );

        boolean isOutOfBounds(int i, int j, int [][] grid) {
            if(i < 0 || i == grid.length) {
                return true;
            }

            return j < 0 || j == grid[0].length;
        }

        public int swimInWater(int[][] grid) {

            visited = new boolean [grid.length][grid[0].length];
            pq.offer(new int [] {0, 0, grid[0][0]});

            while(!pq.isEmpty()) {
                int [] item = pq.poll();
                int node_i =  item[0], node_j = item[1], node_height_time = item[2];

                if(node_i == grid.length - 1 && node_j == grid[0].length - 1) return node_height_time;
                if(visited[node_i][node_j]) continue;

                visited[node_i][node_j] = true;

                //traverse neighbours
                for(int [] d : directions) {
                    int n_i = node_i + d[0], n_j = node_j + d[1];

                    if(isOutOfBounds(n_i, n_j, grid)) continue;
                    if(visited[n_i][n_j]) continue;

                    pq.offer(new int[] { n_i, n_j, Math.max(node_height_time, grid[n_i][n_j]) });
                }
            }

            return  -1;
        }
    }
}
