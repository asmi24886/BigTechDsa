package com.solutions.neetcode.graph.LC286;

import java.util.*;
import java.util.stream.Stream;

public class WallsAndGates {

    public static void main(String [] args) {
        int [][] grid = {
          {2147483647,-1,0,2147483647},
          {2147483647,2147483647,2147483647,-1},
          {2147483647,-1,2147483647,-1},
          {0,-1,2147483647,2147483647}
        };

        Solution sol = new Solution();
        sol.islandsAndTreasure(grid);
        Arrays.stream(grid).map(arr -> Arrays.stream(arr).boxed().toList()).forEach(
                System.out::println
        );
    }

    static class Solution {
        class Cell {
            public Cell(int _x, int _y) {
                x = _x;
                y= _y;
            }

            int x;
            int y;
        }

        //Multi bfs
        public void islandsAndTreasure(int[][] grid) {

            Queue<Cell> q = new LinkedList<>();
            boolean [][] traversed = new boolean[grid.length][grid[0].length];

            for(int i = 0; i < grid.length; i++) {
                for(int j = 0; j < grid[0].length; j++) {
                    if(grid[i][j] == 0) {
                       q.offer(new Cell(i, j));
                    }
                }
            }

            q.offer(null);
            bfs(grid, 0, q, traversed);
        }

        public void bfs(int [][] grid, int step, Queue<Cell> q, boolean [][] traversed) {
            while(!q.isEmpty()) {
                Cell cell = q.remove();

                //step separator
                if(cell == null) {
                    if(q.isEmpty()) return;

                    q.offer(null);
                    bfs(grid, step + 1, q, traversed);
                    return;
                }


                if(cell.x < 0 || cell.x == grid.length)
                    continue;
                if(cell.y < 0 || cell.y == grid[0].length)
                    continue;

                if(grid[cell.x][cell.y] == -1)
                    continue;

                if(traversed[cell.x][cell.y])
                    continue;

                grid[cell.x][cell.y] = step;
                traversed[cell.x][cell.y] = true;

                q.offer(new Cell(cell.x - 1, cell.y));
                q.offer(new Cell(cell.x + 1, cell.y));
                q.offer(new Cell(cell.x, cell.y - 1));
                q.offer(new Cell(cell.x, cell.y + 1));
            }
        }
    }


    static class Solution2 {
        public void islandsAndTreasure(int[][] grid) {

            for(int i = 0; i < grid.length; i++) {
                for(int j = 0; j < grid[0].length; j++) {
                    if(grid[i][j] == Integer.MAX_VALUE) {
                        grid[i][j] = findLeastDistance(grid, i, j, new HashSet<>());
                    }
                }
            }
        }

        private int findLeastDistance(int [][] grid, int row, int col, Set<String> visited) {
            if(row < 0 || row == grid.length)
                return Integer.MAX_VALUE;;

            if(col < 0 || col == grid[0].length)
                return Integer.MAX_VALUE;;

            if(grid[row][col] == -1 || visited.contains(row+"-"+col)) {
                return Integer.MAX_VALUE;
            }

            if(grid[row][col] == 0) {
                return 0;
            }

            if(grid[row][col] > 0 && grid[row][col] < Integer.MAX_VALUE) {
                return grid[row][col];
            }

            visited.add(row+"-"+col);

            int left = findLeastDistance(grid, row, col + 1, visited);
            int right = findLeastDistance(grid, row, col - 1, visited);
            int top = findLeastDistance(grid, row - 1, col, visited);
            int down = findLeastDistance(grid, row + 1, col, visited);

            int minDistance = Stream.of(left, right, top, down).sorted().findFirst().get();

            visited.remove(row+"-"+col);
            if(minDistance == Integer.MAX_VALUE) return minDistance;
            return minDistance + 1;
        }
    }

}
