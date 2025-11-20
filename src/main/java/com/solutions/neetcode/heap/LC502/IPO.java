package com.solutions.neetcode.heap.LC502;

import java.util.;

public class IPO {
    public static void main(String[] args) {
        new Solution().findMaximizedCapital(2, 0, new int[]{1,2,3}, new int[]{0,1,1});
    }

    static class Solution {
        public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

            PriorityQueue<int []> capitalToProfitMinHeap = new PriorityQueue<>(Comparator.comparingInt(i -> i[1]));
            PriorityQueue<Integer> profitMaxHeap = new PriorityQueue<>(Comparator.reverseOrder());

            for(int i = 0; i < profits.length; i++) {
                capitalToProfitMinHeap.add(new int[]{profits[i], capital[i]});
            }

            while(k!=0) {

                while(!capitalToProfitMinHeap.isEmpty() && w >= capitalToProfitMinHeap.peek()[1]) {
                    profitMaxHeap.add(capitalToProfitMinHeap.remove()[0]);
                }

                if(profitMaxHeap.isEmpty()) return w;

                w+=profitMaxHeap.remove();
                k--;
            }
            return w;
        }
    }
}
