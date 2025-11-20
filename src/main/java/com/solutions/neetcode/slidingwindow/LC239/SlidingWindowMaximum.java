package com.solutions.neetcode.slidingwindow.LC239;

import java.util.;

// monotonic decreasing queue
public class SlidingWindowMaximum {

    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {

            return deq(nums, k);
        }

        public int [] deq(int [] nums, int k) {

            Deque<int []> deque = new ArrayDeque<>();
            List<Integer> list =  new ArrayList<>();

            for(int l = 0, r = 0; r < nums.length; r++) {


                // 1. Maintain decreasing order in deque
                while (!deque.isEmpty() && deque.peekLast()[1] < nums[r]) {
                    deque.pollLast();
                }

                // 2. Add current element
                deque.addLast(new int[]{r, nums[r]});

                // 3. Remove all expired indices from front
                if (!deque.isEmpty() && deque.peekFirst()[0] <= r - k) {
                    deque.pollFirst();
                }

                // 4. Record max once window is full
                if (r >= k - 1) {
                    list.add(deque.peekFirst()[1]);
                    l++;
                }

            }
            return list.stream().mapToInt(i -> i).toArray();
        }

        public int [] heap(int [] nums, int k) {
            int l = 0;
            List<Integer> list = new ArrayList<>();
            //max heap
            Queue<int []> heap = new PriorityQueue<>(Comparator.comparing(arr -> arr[1], Comparator.reverseOrder()));

            for(int r = l; r < nums.length; r++) {

                if(r-l+1 < k) {
                    heap.add(new int [] {r, nums[r]});
                    continue;
                }

                // ----------------------------------------------
                heap.add(new int [] {r, nums[r]});
                while(heap.peek()[0] <= r - k) {
                    heap.poll();
                }
                list.add(heap.peek()[1]);
            }

            return list.stream().mapToInt(i->i).toArray();
        }
    }
}
