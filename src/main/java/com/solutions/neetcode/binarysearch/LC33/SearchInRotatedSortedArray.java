package com.solutions.neetcode.binarysearch.LC33;

public class SearchInRotatedSortedArray {
    class Solution {
        public int search(int[] nums, int target) {

            int l = 0;
            int r = nums.length - 1;
            int mid = -1;

            while(l <= r) {

                mid = l + (r-l)/2;

                if(nums[mid] == target) return mid;

                if(l == r)
                    break;

                //CASE: Non rotated
                if(nums[l] < nums[r]) {
                    if(nums[mid] > target) {
                        r = mid - 1;
                    }
                    else {
                        l = mid + 1;
                    }
                }
                else {
                    if(target < nums[mid]) {
                        //case 1: left is greater than mid - search left (Rotated case)
                        if(nums[l] > nums[mid]) {
                            r = mid - 1;
                        }
                        //case 2a: left is smaller than mid and target greater than right most - search left
                        //cas 2b: left is smaller than mid but target is smaller than left - search right
                        else {
                            if(target > nums[r]) {
                                r = mid - 1;
                            }
                            else {
                                l = mid + 1;
                            }
                        }
                    }
                    else {

                        //case 1: right smaller than mid - search right (Rotated case)
                        if(nums[r] < nums[mid]) {
                            l = mid + 1;
                        }
                        //case 2a: right is greater than mid and target greater than right - search left
                        //cas 2b: right is greater than mid and target smaller than right - search right
                        else {
                            if(target > nums[r]) {
                                r = mid - 1;
                            }
                            else {
                                l = mid + 1;
                            }
                        }
                    }
                }
            }
            return -1;
        }
    }
}
