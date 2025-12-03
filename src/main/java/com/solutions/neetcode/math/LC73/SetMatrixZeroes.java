package com.solutions.neetcode.math.LC73;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetMatrixZeroes {
    /*

    [
        [1^,2^,3,4^],
        [5^,0,7,8],
        [0,10,11,12],
        [13^,14,15,0]
     ]
     */
    class Solution {
        public void setZeroes1(int[][] matrix) {
            Set<Integer> zeroRows = new HashSet<>();
            Set<Integer> zeroColumns = new HashSet<>();

            for(int i = 0; i < matrix.length; i++) {
                for(int j = 0; j < matrix[0].length; j++) {
                    if(matrix[i][j] == 0) {
                        zeroRows.add(i);
                        zeroColumns.add(j);
                    }
                }
            }

            for(int i = 0; i < matrix.length; i++) {
                for(int j = 0; j < matrix[0].length; j++) {
                    if(zeroRows.contains(i) || zeroColumns.contains(j)) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        public void setZeroes(int[][] matrix) {
            if (matrix == null || matrix.length == 0) return;

            int m = matrix.length, n = matrix[0].length;
            boolean firstRow = false;
            boolean firstCol = false;

            // determine if first row or first column must be zero
            for (int j = 0; j < n; j++) if (matrix[0][j] == 0) firstRow = true;
            for (int i = 0; i < m; i++) if (matrix[i][0] == 0) firstCol = true;

            // use first row & first column as markers for other rows/cols
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }

            // zero cells based on markers
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
                }
            }

            // zero first row / first column if needed
            if (firstRow) {
                for (int j = 0; j < n; j++) matrix[0][j] = 0;
            }
            if (firstCol) {
                for (int i = 0; i < m; i++) matrix[i][0] = 0;
            }
        }
    }
}
