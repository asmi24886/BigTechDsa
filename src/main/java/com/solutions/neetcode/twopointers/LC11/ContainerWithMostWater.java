package com.solutions.neetcode.twopointers.LC11;

class Solution {
    public int maxArea(int[] height) {

        int maxWater = 0;

        int l = 0;
        int r = height.length - 1;

        while(l != r) {

            int water = Math.min(height[l], height[r]) * (r - l);
            maxWater = Math.max(water, maxWater);

            if(l <= r) {
                l++;
            }
            else {
                r --;
            }
        }
        return maxWater;
    }
}
