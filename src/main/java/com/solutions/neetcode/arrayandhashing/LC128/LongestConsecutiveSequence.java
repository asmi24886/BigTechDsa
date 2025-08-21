package com.solutions.neetcode.arrayandhashing.LC128;

import java.util.HashMap;
import java.util.HashSet;

public class LongestConsecutiveSequence {

    class Solution {
        public int longestConsecutive(int[] nums) {

            HashMap<Integer, Integer[]> map = new HashMap<>();

            for(int num : nums) {
                map.putIfAbsent(num, new Integer[] {null, null});

                //Link previous two way if present
                if(map.get(num-1) != null) {
                    map.get(num)[0] = num - 1;
                    map.get(num-1)[1] = num;
                }

                //Link next two way if present
                if(map.get(num+1) != null) {
                    map.get(num)[1] = num + 1;
                    map.get(num+1)[0] = num;
                }
            }

            int cur = 0;
            int max = 0;
            HashSet<Integer> visited = new HashSet<>();
            for(int num : nums) {
                if(visited.contains(num)) continue;
                visited.add(num);
                cur+=1;
                max = Math.max(max, cur);

                Integer [] node = map.get(num);

                while(node[0] != null) {
                    cur+=1;
                    max = Math.max(max, cur);
                    visited.add(node[0]);
                    node = map.get(node[0]);
                }

                node = map.get(num);
                while(node[1] != null) {
                    cur+=1;
                    max = Math.max(max, cur);
                    visited.add(node[1]);
                    node = map.get(node[1]);
                }

                cur=0;
            }
            return max;
        }

        public int longestConsecutive_optimal(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) set.add(num);

            int max = 0;
            for (int num : set) {
                if (!set.contains(num - 1)) {  // only start at the beginning of a sequence
                    int currentNumberInSequence = num;
                    int curr = 1;

                    while (set.contains(currentNumberInSequence + 1)) {
                        currentNumberInSequence++;
                        curr++;
                    }
                    max = Math.max(max, curr);
                }
            }
            return max;
        }
    }
}
