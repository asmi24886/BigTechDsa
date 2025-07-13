package com.solutions.neetcode.greedy.LC846;

import java.util.Map;
import java.util.TreeMap;

public class HandsOfStraights {

    public static void main(String [] args) {
        int [] arr = {1,2,3,6,2,3,4,7,8};

        /**
         * 1 - 1
         * 2 - 2
         * 3 - 2
         * 4 - 1
         * 6 - 1
         * 7 - 1
         * 8 - 1
         */
        System.out.println(new Solution().isNStraightHand(arr, 3));
    }

    static class Solution {
        public boolean isNStraightHand(int[] hand, int groupSize) {

            if(hand.length % groupSize > 0) return false;

            Map<Integer, Integer> map = new TreeMap<>();

            for (int k : hand) {
                map.put(k, map.getOrDefault(k, 0) + 1);
            }

            for(int key : map.keySet()) {

                boolean canBeGrouped = false;
                int initialCount = map.get(key);

                if(initialCount == 0)
                    continue;

                for(int j =0; j < groupSize; j++) {

                    if(map.getOrDefault(key+j, 0) < initialCount) {
                        canBeGrouped = false;
                        break;
                    }

                    canBeGrouped = true;
                }

                if(!canBeGrouped)
                    continue;

                for(int j =0; j < groupSize; j++) {
                    map.put(key+j, map.get(key+j) - initialCount);
                }
            }

            return map.entrySet().stream().filter(e -> e.getValue() > 0).toList().isEmpty();
        }
    }
}
