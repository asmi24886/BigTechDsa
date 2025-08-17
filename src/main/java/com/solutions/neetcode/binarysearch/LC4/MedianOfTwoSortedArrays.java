package com.solutions.neetcode.binarysearch.LC4;

public class MedianOfTwoSortedArrays {

    // [7,8,9]
    // [1,2,3,4,5,6]
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            return nums1.length > nums2.length ? findMedian(nums2, nums1) : findMedian(nums1, nums2);
        }

        public double findMedian(int [] arr1, int [] arr2) {

            int min_count_arr1 = 0;
            int max_count_arr1 = arr1.length;

            int totalLength = arr1.length + arr2.length;
            int halfLength = (totalLength + 1)/2; //always taking one element extra if odd

            while(min_count_arr1 <= max_count_arr1) { //either have taken all from arr1 or non from arr1

                // Binary search on solution space / answers
                //left contains smaller elements, right contains larger elements when two arrays are combined
                int partition_count_arr1 = min_count_arr1 + (max_count_arr1 - min_count_arr1)/2;
                int partition_count_arr2 = halfLength - partition_count_arr1;

                int leftMax1 = partition_count_arr1 == 0? Integer.MIN_VALUE : arr1[partition_count_arr1 - 1];
                int rightMin1 = partition_count_arr1 == arr1.length? Integer.MAX_VALUE : arr1[partition_count_arr1];

                int leftMax2 = partition_count_arr2 == 0? Integer.MIN_VALUE : arr2[partition_count_arr2 - 1];
                int rightMin2 = partition_count_arr2 == arr2.length? Integer.MAX_VALUE : arr2[partition_count_arr2];


                if(leftMax1 <= rightMin2 && leftMax2 <= rightMin1) {
                    return ((totalLength & 1) == 0) ?
                            (double)(Math.max(leftMax1, leftMax2) + Math.min(rightMin1, rightMin2))/2
                            : Math.max(leftMax1, leftMax2);
                }

                if (leftMax1 > rightMin2) {
                    max_count_arr1 = partition_count_arr1 - 1;
                }
                else {
                    min_count_arr1 = partition_count_arr1 + 1;
                }

            }

            return 0.0;
        }
    }
}
