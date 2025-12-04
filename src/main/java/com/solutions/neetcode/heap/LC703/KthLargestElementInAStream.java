package com.solutions.neetcode.heap.LC703;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAStream {

    static class KthLargest {

        int size;
        Queue<Integer> minHeap;
        public KthLargest(int k, int[] nums) {
            size = k;
            minHeap = new PriorityQueue<>(k);
            for(int num: nums) {
                add(num);
            }
        }

        private void ensureCapacity() {
            while(minHeap.size() > size) {
                minHeap.poll();
            }
        }

        public int add(int val) {
            minHeap.offer(val);
            ensureCapacity();
            return minHeap.peek();
        }
    }

/*
  Your KthLargest object will be instantiated and called as such:
  KthLargest obj = new KthLargest(k, nums);
  int param_1 = obj.add(val);
 */
}
