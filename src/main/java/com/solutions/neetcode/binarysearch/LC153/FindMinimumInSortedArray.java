package com.solutions.neetcode.binarysearch.LC153;

public class FindMinimumInSortedArray {
    class Solution {
        public int findMin(int[] nums) {

            int l = 0;
            int r = nums.length - 1;
            int mid = -1;

            while(l<=r) {
                if(nums[l] <= nums[r]) {
                    return nums[l];
                }

                mid = l + (r-l)/2;

                //Lowest must be on the left
                if(nums[mid] > nums[r]) {
                    l = mid + 1;
                }
                else {
                    r = mid;
                }
            }

            return nums[mid];
        }
    }
}
