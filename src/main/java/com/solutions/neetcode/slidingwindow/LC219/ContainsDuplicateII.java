package com.solutions.neetcode.slidingwindow.LC219;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicateII {
    class Solution {
        public boolean containsNearbyDuplicate2(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {

                map.putIfAbsent(nums[i], i);
                int j = map.get(nums[i]);

                if(j - i == 0)
                    continue;

                if(i-j <= k ) {
                    return true;
                }

                if (i-j > k){
                    map.put(nums[i], i);
                }
            }

            return false;
        }

        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Set<Integer> set = new HashSet<>();

            int i = 0;
            for (int j = 0; j < nums.length; j++) {

                if(j-i > k) {
                    set.remove(nums[i]);
                    i++;
                }

                if(set.contains(nums[j])) return true;
                set.add(nums[j]);

            }

            return false;
        }
    }
}
