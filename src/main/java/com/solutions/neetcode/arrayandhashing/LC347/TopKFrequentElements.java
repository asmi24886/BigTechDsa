package com.solutions.neetcode.arrayandhashing.LC347;

import java.util.*;

public class TopKFrequentElements {

    class Solution {
        public int[] topKFrequent(int[] nums, int k) {

            HashMap<Integer, Integer> map = new HashMap<>();

            for(int i :  nums) {
                map.putIfAbsent(i, 0);
                map.put(i, map.get(i) + 1);
            }

            Queue<int []> minHeap = new PriorityQueue<>(Comparator.comparingInt(it -> it[1]));

            for(Map.Entry<Integer, Integer> e : map.entrySet()) {
                minHeap.add(new int [] {e.getKey(), e.getValue()});
                if(minHeap.size() > k) {
                    minHeap.poll();
                }
            }

            int [] ans = new int [k];
            int i = 0;

            while(!minHeap.isEmpty()) {
                ans[i++] = minHeap.poll()[0];
            }

            return ans;
        }
    }
}
