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

        public int[] topKFrequent_bucketSort(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();

            for(int i :  nums) {
                map.putIfAbsent(i, 0);
                map.put(i, map.get(i) + 1);
            }

            ArrayList<Integer> [] countBuckets = new ArrayList[nums.length + 1];

            Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
            for(Map.Entry<Integer, Integer> e : entries) {
                if(countBuckets[e.getValue()] == null) {
                    countBuckets[e.getValue()] = new ArrayList<>();
                }

                countBuckets[e.getValue()].add(e.getKey());
            }

            int i = nums.length;
            int [] result = new int[k];
            while(true) {
                if(k == 0 || i == 0) {
                    break;
                }

                if(countBuckets[i] == null) {
                    i--;
                    continue;
                }

                List<Integer> keys = countBuckets[i--];

                for(int key : keys) {
                    k--;
                    result[k] = key;

                    if(k == 0) {
                        break;
                    }
                }
            }

            return result;
        }
    }

}
