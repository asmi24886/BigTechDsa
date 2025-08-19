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
    }
}
