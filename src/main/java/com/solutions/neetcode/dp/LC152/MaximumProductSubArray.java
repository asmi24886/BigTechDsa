package com.solutions.neetcode.dp.LC152;

import java.util.ArrayList;
import java.util.List;

public class MaximumProductSubArray {
    class Solution {

        public int maxProduct(int[] nums) {
            return prefix_suffix_dp(nums);
        }

        //prefix-suffix pattern
        int prefix_suffix_dp(int [] nums) {
            int prefix = 0;
            int suffix = 0;

            int max = nums[0];
            for(int i = 0; i < nums.length; i++) {
                prefix = (prefix == 0? 1 : prefix) * nums[i];
                suffix = (suffix == 0? 1: suffix) * nums[nums.length - 1 - i];

                max = Math.max(max, Math.max(prefix, suffix));
            }

            return max;
        }
        // kadane - prefix sum / product with additional book keeping
        int dp_prefix_product_kadane(int [] nums) {
            if(nums.length == 1)
                return nums[0];

            int MIN = 1;
            int MAX = 1;
            int maxProduct = Integer.MIN_VALUE;

            for(int num : nums) {
                int temp = Math.min(
                        Math.min(MIN * num, MAX * num),
                        num
                );

                MAX = Math.max(
                        Math.max(MIN * num, MAX * num),
                        num
                );

                MIN = temp;

                maxProduct = Math.max(maxProduct, MAX);
            }

            return maxProduct;
        }

        int slidingWindow(int [] nums) {
            int maxSubArrayProduct = Integer.MIN_VALUE;

            // Seperate out sub arrays by 0 if any
            List<List<Integer>> subArrays = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            for(int num : nums) {
                maxSubArrayProduct = Math.max(maxSubArrayProduct, num);
                if(num == 0) {
                    if(list.isEmpty())
                        continue;

                    subArrays.add(list);
                    list = new ArrayList<>();
                }
                else {
                    list.add(num);
                }
            }

            if(!list.isEmpty()) {
                subArrays.add(list);
            }

            //Start the actual algo
            for(List<Integer> sub : subArrays) {
                if(sub.size() == 1) {
                    maxSubArrayProduct = Math.max(maxSubArrayProduct, sub.get(0));
                    continue;
                }

                //Count the total number of negs
                int negCount = (int) sub.stream().filter(it -> it < 0).count();
                if(negCount % 2 == 0) {
                    maxSubArrayProduct = Math.max(
                            maxSubArrayProduct, sub.stream().reduce( 1, (a,b) -> a*b )
                    );
                    continue;
                }

                // implement the sliding window
                int req = negCount - 1;
                int curr = 0;
                int product = 1;
                for(int i = 0, j = 0; i < sub.size(); i++) {
                    product*=sub.get(i);
                    maxSubArrayProduct = Math.max(product, maxSubArrayProduct);

                    if(sub.get(i) < 0) curr++;

                    if(curr <= req) continue;

                    while(curr > req) {
                        if(sub.get(j) < 0) {
                            curr--;
                        }

                        product/=sub.get(j);
                        maxSubArrayProduct = Math.max(product, maxSubArrayProduct);

                        j++;
                    }
                }
            }


            return maxSubArrayProduct;
        }

        int plainDp(int [] nums) {
            int [] dp;
            int max = Integer.MIN_VALUE;
            dp = new int [nums.length];
            for(int i = 0; i < nums.length; i++) {
                dp[i] = nums[i];
                max = Math.max(dp[i], max);
                for(int j = i+1; j < nums.length; j++) {
                    dp[j] = dp[j - 1] * nums[j];
                    max = Math.max(dp[j], max);
                }
            }
            return max;
        }
    }
}
