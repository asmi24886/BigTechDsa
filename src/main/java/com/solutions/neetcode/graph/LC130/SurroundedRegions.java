package com.solutions.neetcode.graph.LC130;

public class SurroundedRegions {
    class Solution {
        char [][] board;
        int ROWS, COLS;
        int [][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        public void solve(char[][] b) {
            board = b;
            ROWS = board.length;
            COLS = board[0].length;

            for(int i = 0; i < ROWS; i++) {
                dfs(i, 0);
                dfs(i, COLS - 1);
            }
            for(int i = 0; i < COLS; i++) {
                dfs(0, i);
                dfs(ROWS - 1, i);
            }

            for(int i = 0; i < ROWS; i++) {
                for(int j = 0; j < COLS; j++) {
                    if(board[i][j] == 'O')
                        board[i][j] = 'X';
                    else if(board[i][j] == '.')
                        board[i][j] = 'O';
                }
            }

        }

        public void dfs(int i, int j) {
            if(board[i][j] != 'O')
                return;

            board[i][j] = '.';

            for(int [] d : directions) {
                int x = i + d[0];
                int y = j + d[1];

                if(x < 0 || x == ROWS) continue;
                if(y < 0 || y == COLS) continue;
                dfs(x, y);
            }
        }
    }
}
