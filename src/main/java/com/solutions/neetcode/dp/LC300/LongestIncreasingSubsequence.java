package com.solutions.neetcode.dp.LC300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {

    class SolutionN2 {
        public int lengthOfLIS(int[] nums) {

            int [] dp = new int[nums.length];
            dp[dp.length - 1] = 1;

            for(int i = nums.length - 2; i >= 0; i--) {
                int max = 0;
                for(int j = i + 1; j < nums.length; j++) {
                    if(nums[i] < nums[j]) {
                        max = Math.max(max, dp[j]);
                    }
                }

                dp[i] = max + 1;
            }

            return Arrays.stream(dp).max().getAsInt();
        }
    }

    class Solution {
        public int lengthOfLIS(int[] nums) {

            List<Integer> result = new ArrayList<>();

            for(int value : nums) {

                if(result.isEmpty() || result.getLast() < value) {
                    result.add(value);
                    continue;
                }

                int idx = Collections.binarySearch(result, value); // -insertion_point -1
                if(idx < 0) result.set(-1*idx - 1, value);
            }

            return result.size();
        }
    }
}
