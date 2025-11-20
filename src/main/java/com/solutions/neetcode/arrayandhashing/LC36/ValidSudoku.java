package com.solutions.neetcode.arrayandhashing.LC36;

import java.util.*;

public class ValidSudoku {
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            Map<Integer, Set<Character>> rows = new HashMap<>();
            Map<Integer, Set<Character>> cols = new HashMap<>();
            Map<Integer, Set<Character>> boxes = new HashMap<>();

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    char ch = board[i][j];
                    if (ch == '.')
                        continue;

                    // row check
                    rows.putIfAbsent(i, new HashSet<>());
                    if (!rows.get(i).add(ch))
                        return false;

                    // col check
                    cols.putIfAbsent(j, new HashSet<>());
                    if (!cols.get(j).add(ch))
                        return false;

                    // box check
                    int boxIndex = (i / 3) * 3 + (j / 3); //Imp
                    boxes.putIfAbsent(boxIndex, new HashSet<>());
                    if (!boxes.get(boxIndex).add(ch))
                        return false;
                }
            }
            return true;
        }

        public boolean isValidSudoku_bitmask(char[][] board) {
            int[] rows = new int[9];
            int[] cols = new int[9];
            int[] squares = new int[9];

            for (int r = 0; r < 9; r++) {
                for (int c = 0; c < 9; c++) {

                    if (board[r][c] == '.') continue;

                    int val = board[r][c] - '1';

                    if (
                        (rows[r] & (1 << val)) > 0 ||
                        (cols[c] & (1 << val)) > 0 ||
                        (squares[(r / 3) * 3 + (c / 3)] & (1 << val)) > 0) {
                            return false;
                        }

                    rows[r] |= (1 << val);
                    cols[c] |= (1 << val);
                    squares[(r / 3) * 3 + (c / 3)] |= (1 << val);
                }
            }
            return true;
        }
    }
}
