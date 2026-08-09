package com.solutions.neetcode.arrayandhashing.LC169;

import java.util.HashMap;

public class MajorityElement {
    class Solution {

        public int majorityElement(int[] nums) {
            //Boyer Moore voting
            int num = 0, count = 0;

            for(int n : nums) {
                if(count == 0) {
                    n = num;
                }

                if(n == num) {
                    count++;
                }
                else count --;
            }

            return num;
        }

        public int majorityElement2(int[] nums) {
            HashMap<Integer, Integer> count = new HashMap<>();

            for(int num : nums) {
                count.put(num, count.getOrDefault(num, 0) + 1);
                if(count.get(num) > nums.length/2)
                    return num;
            }

            return 0;
        }
    }
}
