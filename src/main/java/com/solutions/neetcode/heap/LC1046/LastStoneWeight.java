package com.solutions.neetcode.heap.LC1046;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LastStoneWeight {

    class Solution {

        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        public int lastStoneWeight(int[] stones) {

            for (int stone: stones) {
                maxHeap.offer(stone);
            }

            while(maxHeap.size() > 1) {
                int greater = maxHeap.poll();
                int smaller = maxHeap.poll();
                if(greater > smaller) {
                    maxHeap.offer(smash(smaller, greater));
                }
            }

            if(maxHeap.isEmpty()) return 0;
            return maxHeap.poll();
        }

        private int smash(int smaller, int greater) {
            return greater - smaller;
        }
    }

}
