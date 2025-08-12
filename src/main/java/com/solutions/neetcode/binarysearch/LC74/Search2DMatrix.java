package com.solutions.neetcode.binarysearch.LC74;

public class Search2DMatrix {

    // One other option is to treat is as an entire sorted list where matrix middle element for ith row and jth column is i = mid / col and j = mid % 2
    // lets say 5 rows with 4 columns. Total element 20. Loop runs from 0 to 19.
    // mid = 0 + (19 - 0)/2 = 9, now middle element row is 9/4 (col) = 2.x = 2 and column = 9%4 = 1 -> so matrix[2][1]
    class Solution {
        public boolean searchMatrix_naive(int[][] matrix, int target) {

            int l = 0, r = matrix[0].length - 1;
            int u = 0, d = matrix.length - 1;

            int mid = 0;
            while(u <= d) {
                mid = u + (d-u)/2;
                if(matrix[mid][0] == target) return true;

                if(target < matrix[mid][0]) {
                    d = mid - 1;
                }
                else {

                    if(target <= matrix[mid][r])
                        break;

                    u = mid + 1;
                }
            }

            int [] searchRow = matrix[mid];

            while(l <= r) {
                mid = l + (r - l)/2;

                if(searchRow[mid] == target) return true;

                if(target < searchRow[mid]) {
                    r = mid - 1;
                }
                else {
                    l = mid + 1;
                }
            }

            return false;
        }
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        int l = 0;
        int r = (matrix.length * matrix[0].length) - 1;
        int mid = 0;

        while(l <= r) {
            mid = l + (r - l)/2;
            int midValue = matrix[mid/matrix[0].length][mid%matrix[0].length];
            if(target == midValue) return true;

            if(midValue > target) {
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }

        return  false;
    }
}
