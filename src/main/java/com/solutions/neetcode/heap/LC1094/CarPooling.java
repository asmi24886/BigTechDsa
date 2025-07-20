package com.solutions.neetcode.heap.LC1094;

import java.util.*;

public class CarPooling {
    class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
            return minHeapMethod(trips, capacity);
        }
    }

    public static boolean minHeapMethod(int[][] trips, int capacity) {

        Arrays.sort(trips, Comparator.comparing(a -> a[1]));
        PriorityQueue<int []> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a[0]));

        int total = 0;
        for(int [] trip : trips) {

            while(!minHeap.isEmpty() && minHeap.peek()[0] <= trip[1]) {
                total-=minHeap.poll()[1];
            }

            total+=trip[0];

            if(total > capacity)
                return false;

            minHeap.offer(new int [] {trip[2], trip[0]});
        }

        return true;
    }

    public static boolean twoHashMapMethod(int[][] trips, int capacity) {

        Map<Integer, Integer> entryMap = new HashMap<>();
        Map<Integer, Integer> exitMap = new HashMap<>();

        int tripStart = Integer.MAX_VALUE;
        int tripEnd = 0;

        for(int [] trip : trips) {
            entryMap.put(trip[1], entryMap.getOrDefault(trip[1], 0) + trip[0]);
            exitMap.put(trip[2], exitMap.getOrDefault(trip[2], 0) + trip[0]);

            tripStart = Math.min(tripStart, trip[1]);
            tripEnd = Math.max(tripEnd, trip[2]);
        }

        int point = tripStart;
        int totalFilled = 0;
        while(point <= tripEnd) {

            if(entryMap.get(point) != null) {
                totalFilled+= entryMap.get(point);
            }

            if(exitMap.get(point) != null) {
                totalFilled-=exitMap.get(point);
            }

            if(totalFilled > capacity)
                return  false;

            point++;
        }

        return  true;
    }
}
