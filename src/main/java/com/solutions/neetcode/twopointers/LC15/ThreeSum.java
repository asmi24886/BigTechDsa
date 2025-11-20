package com.solutions.neetcode.twopointers.LC15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {

    class Solution {
        public List<List<Integer>> threeSum_hashmap(int[] nums) {

            List<List<Integer>> res = new ArrayList<>();
            HashMap<Integer, Integer> count = new HashMap<>();
            Arrays.sort(nums);

            for (int num : nums) {
                count.put(num, count.getOrDefault(num, 0) + 1);
            }

            for (int i = 0; i < nums.length; i++) {

                count.put(nums[i], count.get(nums[i]) - 1);
                if (i > 0 && nums[i] == nums[i - 1]) continue;

                for (int j = i + 1; j < nums.length; j++) {

                    // Consider - [-3,-3,-3, 4, 5, 6] -> <-3> -3 + 6 = 0, but <-3> + 6 -3 = 0 as well.. where i is marked by <>... j needs to decrement the count to mark already used in the i loop
                    //Difficult intiuition but good to learn
                    count.put(nums[j], count.get(nums[j]) - 1);
                    if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                    int target = nums[i] + nums[j];

                    if (count.getOrDefault(-1  target, 0) > 0) {
                        res.add(Arrays.asList(nums[i], nums[j], -1  target));
                    }
                }

                //Reset the count
                for (int j = i + 1; j < nums.length; j++) {
                    count.put(nums[j], count.get(nums[j]) + 1);
                }
            }


            return res;
        }

        // [-1,0,1,2,-1,-4]
        //[-4, -1, -1 0, 1, 2]

        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);

            for (int pivot = 0; pivot < nums.length - 2; pivot++) {

                if (nums[pivot] > 0)
                    return res;
                if (pivot > 0 && nums[pivot] == nums[pivot - 1])
                    continue;

                int l = pivot + 1, r = nums.length - 1;
                int target = -1  nums[pivot];

                while (l < r) {
                    if (nums[l] + nums[r] > target) {
                        r--;
                    } else if (nums[l] + nums[r] < target) {
                        l++;
                    } else {
                        res.add(List.of(nums[l], nums[r], nums[pivot]));
                        l++;
                        r--;

                        while (l < r && nums[l] == nums[l - 1])
                            l++;
                    }
                }
            }

            return res;
        }
    }
}
