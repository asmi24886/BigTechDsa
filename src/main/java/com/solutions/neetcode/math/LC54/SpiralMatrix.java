package com.solutions.neetcode.math.LC54;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {

            int TOP = 0;
            int BOTTOM = matrix.length - 1;
            int LEFT = 0;
            int RIGHT = matrix[0].length - 1;

            List<Integer> list = new ArrayList<>();

            //[1, 2, 3] OR [1,
            //              2,
            //              3]


            // [2,5,8]
            // [4,0,-1]

            //In bounds
            while(TOP <= BOTTOM && LEFT <= RIGHT) {

                //Try traversing right
                for(int i = LEFT; i <= RIGHT; i++) {
                    list.add(matrix[TOP][i]);
                }

                TOP+=1;

                // A special case, consider example above
                if(TOP > BOTTOM) {
                    return list;
                }

                for(int i = TOP; i <= BOTTOM; i++) {
                    list.add(matrix[i][RIGHT]);
                }

                RIGHT-=1;

                // Another special case, consider example above
                if(LEFT > RIGHT) {
                    return list;
                }

                for(int i = RIGHT; i >= LEFT; i--) {
                    list.add(matrix[BOTTOM][i]);
                }

                BOTTOM-=1;

                for(int i = BOTTOM; i >= TOP; i--) {
                    list.add(matrix[i][LEFT]);
                }

                LEFT+=1;
            }

            return list;

        }
    }
}
