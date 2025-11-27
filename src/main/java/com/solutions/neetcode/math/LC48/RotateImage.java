package com.solutions.neetcode.math.LC48;

public class RotateImage {
    // Check png
    class Solution {
        public void rotate(int[][] matrix) {

            int i = 0; int j = matrix.length - 1;

            while(i < j) {

                int k = i;

                while(k < j) {
                    int offset = k - i;

                    int temp = matrix[i][k]; // top cached

                    //left goes to top
                    matrix[i][k] = matrix[j-offset][i];

                    //bottom goes to left
                    matrix[j-offset][i] = matrix[j][j-offset];

                    //right goes to bottom
                    matrix[j][j-offset] = matrix[k][j];

                    //cache goes to right
                    matrix[k][j] = temp;
                    k++;
                }

                i++;
                j--;
            }
        }
    }

    void swap(int[][] matrix) {

        int i = 0; int j = matrix.length - 1;

        while(i < j) {

            int k = i;

            while(k < j) {
                int offset = k - i;

                int temp = matrix[i][k]; // top cached

                //left goes to top
                matrix[i][k] = matrix[j-offset][i];

                //bottom goes to left
                matrix[j-offset][i] = matrix[j][j-offset];

                //right goes to bottom
                matrix[j][j-offset] = matrix[k][j];

                //cache goes to right
                matrix[k][j] = temp;
                k++;
            }

            i++;
            j--;
        }
    }

    void transposeAndReverse(int[][] matrix) {
        int n = matrix.length;
        //transpose
        for(int i = 0; i < n - 1; i++) {
            for(int j = i+1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;

            }
        }

        //rotate
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }
}
