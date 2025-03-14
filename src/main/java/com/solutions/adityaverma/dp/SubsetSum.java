package com.solutions.adityaverma.dp;

import java.util.Arrays;

public class SubsetSum {

    static class Solution {

        int [] arr = {2, 3, 7, 8, 10};
        int target = 12;

        public boolean has_subset_sum() {
            int dp_i = arr.length + 1;
            int dp_j = target + 1;

            boolean [] T = new boolean[dp_j];
            Arrays.fill(T, false);
            T[0] = true; //when no elements are in arr then 0 can be achieved

            for(int i = 1; i < dp_i; i++) {
                for(int j = dp_j - 1; j >= arr[i - 1]; j--) { //Logic - anything left of this number will always be value of previous row, so better keep it unchanged
                    boolean include = T[j] || T[j-arr[i - 1]];

                    if(include) {
                        T[j] = true; //include else keep previous value to carry over
                    }
                }
            }

            return T[dp_j - 1];
        }
    }

    public static void main(String [] args) {
        Solution s = new Solution();
        System.out.println(s.has_subset_sum());
    }
}
