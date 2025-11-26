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


        public int[][] merge2(int[][] intervals) {
            int max = 0;

            for(int [] i : intervals) {
                max = Math.max(i[1], max);
            }

            int [] buffer = new int [max + 1];
            Arrays.fill(buffer, -1);

            for(int [] i : intervals) {
                buffer[i[0]] = Math.max(buffer[i[0]], i[1]);
            }

            int end = -1;

            for(int i = 0; i < buffer.length; i++) {
                if(buffer[i] != -1) {
                    end = Math.max(end, buffer[i]);
                }

                if(i < end) buffer[i] = 1;
                else if(i == end) buffer[i] = 2;
            }

            List<int []> result = new ArrayList<>();
            int i_start = -1;

            for(int i = 0; i < buffer.length; i++) {
                if(buffer[i] == 2) {
                    result.add(new int [] {i_start == -1 ? i : i_start, i}); // edge case where first element encountered was start and an end
                    i_start = -1;
                }
                else if(buffer[i] == 1 && i_start == -1) {
                    i_start = i;
                }
            }

            return result.toArray(new int[result.size()][2]);
        }
    }

}
