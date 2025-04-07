package com.solutions.neetcode.heap.LC973;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointsToOrigin {

    class Solution {

        Comparator<int []> maxHeapComparator = Comparator.comparing(
                this::distanceToOrigin,
                Comparator.reverseOrder()
        );

        Queue<int[]> heap = new PriorityQueue<>(maxHeapComparator);

        public int[][] kClosest(int[][] points, int k) {
            for(int [] p : points) {
                heap.offer(p);
                if(heap.size() > k) {
                    heap.poll();
                }
            }

            return heap.stream().toArray(int[][]::new);
        }

        private double distanceToOrigin(int [] p1) {
            return Math.sqrt(Math.pow(p1[0], 2) + Math.pow(p1[1], 2));
        }
    }
}
