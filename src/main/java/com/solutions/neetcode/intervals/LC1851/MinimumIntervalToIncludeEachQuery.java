package com.solutions.neetcode.intervals.LC1851;

import java.util.*;

public class MinimumIntervalToIncludeEachQuery {

    class Solution {
        public int[] minInterval(int[][] intervals, int[] queries) {

            HashMap<Integer, List<Integer>> indexMap = new HashMap<>();
            for(int i = 0; i < queries.length; i++) {
                indexMap.putIfAbsent(queries[i], new ArrayList<>());
                indexMap.get(queries[i]).add(i);
            }

            Arrays.sort(intervals, Comparator.comparing((int [] i) -> i[0]));
            Arrays.sort(queries);

            PriorityQueue<int []> pq = new PriorityQueue<>(Comparator.comparing((int [] i) -> i[0]));
            int j = 0;
            int i = 0;
            HashMap<Integer, Integer> diffMap = new HashMap<>();

            while(j < queries.length) {
                if(i < intervals.length) {
                    int [] interval = intervals[i];
                    if(queries[j] >= interval[0]) {
                        pq.offer(new int [] {interval[1] - interval[0], interval[1]});
                        i++;
                        continue;
                    }
                }

                while(!pq.isEmpty()) {
                    if(queries[j] > pq.peek()[1]) {
                        pq.poll();
                        continue;
                    }

                    diffMap.put(queries[j], pq.peek()[0] + 1);
                    break;
                }

                diffMap.putIfAbsent(queries[j], -1);

                j++;
            }

            int [] result = new int [queries.length];
            for(Map.Entry<Integer, Integer> e : diffMap.entrySet()) {
                List<Integer> indexes = indexMap.get(e.getKey());

                for(int idx : indexes) {
                    result[idx] = e.getValue();
                }

            }
            return result;
        }

        public int[] minInterval_bruteforce(int[][] intervals, int[] queries) {

            HashMap<Integer, int []> map = new HashMap<>();

            for(int [] interval : intervals) {

                int start = interval[0];
                int end = interval[1];

                for(int i = start; i <= end; i++) {
                    map.putIfAbsent(i, interval);

                    int diff = map.get(i)[1] - map.get(i)[0];
                    if(diff > (end - start)) {
                        map.put(i, interval);
                    }
                }
            }

            int [] result = new int [queries.length];

            for(int i = 0; i < result.length; i++) {
                int [] interval = map.get(queries[i]);
                result[i] = interval == null ? -1 : interval[1] - interval[0] + 1;
            }

            return result;
        }
    }
}
