package com.solutions.adityaverma.dp;

public class CountOfSubsetSum {

    static class Solution {

        int [] arr = {2, 3, 5, 6, 8, 10};
        int target = 10;

        public int count_subset_sum() {
            int dp_i = arr.length;
            int dp_j = target;

            int [] T = new int[dp_j+1];

            T[0] = 1; //when no elements are in arr then 0 can be achieved

            for(int i = 1; i <= dp_i; i++) {
                for(int j = dp_j; j >= arr[i - 1]; j--) { //Logic - anything left of this number will always be value of previous row, so better keep it unchanged
                    T[j] = T[j] + T[j-arr[i - 1]];
                }
            }

            return T[T.length - 1];
        }
    }

    public static void main(String [] args) {
        Solution s = new Solution();
        System.out.println(s.count_subset_sum());
    }
}
