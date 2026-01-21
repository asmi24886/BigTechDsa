package com.solutions.neetcode.dp.LC329;

public class LongestIncreasingPathInAMatrix {
    class Solution {
        int max = 0;
        int [][] dp;
        int M = 0;
        int N = 0;

        int [][] directions = new int [][] {
                {0,1},
                {1,0},
                {0, -1},
                {-1, 0}
        };

        public int longestIncreasingPath(int[][] matrix) {
            M = matrix.length;
            N = matrix[0].length;

            dp = new int[M][N];

            for(int i = 0; i < M; i++) {
                for(int j = 0; j < N; j++) {
                    max = Math.max(computePath(matrix, i, j), max);
                }
            }

            return max;
        }

        int computePath(int[][] matrix, int i, int j) {
            if(dp[i][j] != 0) {
                return dp[i][j];
            }

            int longestPath = 0;

            for(int [] d : directions) {
                int x = i + d[0];
                int y = j + d[1];

                if(x < 0 || x == M || y < 0 || y == N) {
                    continue;
                }

                if(matrix[i][j] < matrix[x][y])
                    longestPath = Math.max(computePath(matrix, x, y), longestPath);
            }

            dp[i][j] = longestPath + 1;

            return dp[i][j];
        }
    }
}
