package com.solutions.neetcode.intervals.LC56;

import java.util.*;

public class MergeIntervals {
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparing((int [] i) -> i[0]));
            List<int []> res = new ArrayList<>();

            for(int [] i : intervals) {
                if(res.isEmpty()) {
                    res.add(i);
                    continue;
                }

                int [] last = res.get(res.size()-1);

                if(last[1] >= i[0]) {
                    last[1] = Math.max(last[1], i[1]);
                    continue;
                }

                res.add(i);
            }

            return res.toArray(new int [res.size()][]);
        }
    }

}
