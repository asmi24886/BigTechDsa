package com.solutions.neetcode.heap.LC621;

import java.util.*;

public class TaskScheduler {

    public static void main(String[] args) {
        char [] tasks = {'A','A','A','B','B','B'};
        int n = 2;
        System.out.println(new Solution().leastInterval(tasks, n));
    }

    static class Solution {
        public int leastInterval(char[] tasks, int n) {

            int counter = 0;

            HashMap<Character, Integer> taskCountMap = new HashMap<>();
            for(char c : tasks) {
                taskCountMap.put(c, taskCountMap.getOrDefault(c, 0) + 1);
            }

            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            maxHeap.addAll(taskCountMap.values());

            Queue<int []> schedulingQueue = new LinkedList<>();

            while(true) {
                if (maxHeap.isEmpty() && schedulingQueue.isEmpty())
                    return counter;

                counter++;
                if(!schedulingQueue.isEmpty() && schedulingQueue.peek()[1] < counter) {
                    maxHeap.add(schedulingQueue.remove()[0]);
                }

                if(!maxHeap.isEmpty()) {
                    int taskCount = maxHeap.remove();
                    if(taskCount > 1) {
                        schedulingQueue.add(new int[] {taskCount - 1, counter+n});
                    }
                }

            }
        }
    }
}
