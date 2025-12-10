package com.solutions.neetcode.backtracking.LC79;

public class WordSearch {
    class Solution {
        String res = "";
        char [][] grid;
        boolean [][] visiting;
        int [][] directions = new int [][] {
                {0,1},
                {1, 0},
                {0, -1},
                {-1, 0}
        };

        public boolean exist(char[][] board, String word) {
            grid = board;
            visiting = new boolean[board.length][board[0].length];
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[0].length; j++) {
                    if(dfs(i, j, word, 0)) return true;
                }
            }
            return false;
        }

        boolean dfs(int i, int j, String word, int w) {
            if(w == word.length()) return false;
            if(i < 0 || i == grid.length) return false;
            if(j < 0 || j == grid[0].length) return false;
            if(word.charAt(w) != grid[i][j]) return false;
            if(visiting[i][j]) return false;

            visiting[i][j] = true;
            res  = res + grid[i][j];

            if(res.equals(word)) return true;

            for(int [] d : directions) {
                int new_i = i + d[0];
                int new_j = j + d[1];
                if(dfs(new_i, new_j, word, w+1)) return true;
            }

            visiting[i][j] = false;
            res = res.substring(0, res.length() - 1);
            return false;
        }
    }
}
