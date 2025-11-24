package com.solutions.neetcode.intervals.LC435;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparing((int [] i) -> i[1] ));

            int [] prev = new int [] {Integer.MIN_VALUE,Integer.MIN_VALUE};
            int remove_count = 0;
            for(int [] i : intervals) {
                if(i[0] < prev[1]) remove_count++;
                else {
                    prev = i;
                }
            }

            return remove_count;
        }
    }
}
