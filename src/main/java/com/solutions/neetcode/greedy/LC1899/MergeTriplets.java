package com.solutions.neetcode.greedy.LC1899;

public class MergeTriplets {

    class Solution {
        public boolean mergeTriplets(int[][] triplets, int[] target) {

            //int n = 0;
            boolean[] found = new boolean[3];

            for (int[] i : triplets) {
                if (i[0] <= target[0] && i[1] <= target[1] && i[2] <= target[2]) {
                    if (i[0] == target[0])
                        found[0] = true;

                    if (i[1] == target[1])
                        found[1] = true;

                    if (i[2] == target[2])
                        found[2] = true;
                }
            }

            return found[0] && found[1] && found[2];
        }
    }

}
