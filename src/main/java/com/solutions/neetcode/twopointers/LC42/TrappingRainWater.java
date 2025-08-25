package com.solutions.neetcode.twopointers.LC42;

//4 pointer
public class TrappingRainWater {

    class Solution {

        public int trap(int[] height) {
            if (height.length < 3)
                return 0;
            int totalWater = 0;

            int l = 0;
            int r = height.length - 1;

            int leftMax = height[l];
            int rightMax = height[r];

            while (l < r) {
                if (height[l] >= leftMax) {
                    leftMax = height[l];
                }

                if (height[r] >= rightMax) {
                    rightMax = height[r];
                }

                if (leftMax <= rightMax) {
                    if (height[l] < leftMax && height[l] < rightMax) {
                        totalWater += Math.min(leftMax, rightMax) - height[l];
                    }
                    l++;
                } else {
                    if (height[r] < leftMax && height[r] < rightMax) {
                        totalWater += Math.min(leftMax, rightMax) - height[r];
                    }
                    r--;
                }
            }

            return totalWater;
        }


        public int trap2(int[] height) {

            if(height.length < 3)
                return 0;

            int [] leftMaxArr = new int [height.length];
            int [] rightMaxArr = new int[height.length];

            int leftMax = 0;
            int rightMax = 0;
            for(int i = 0; i < height.length; i++) {
                if(leftMax < height[i]) {
                    leftMax = height[i];
                }

                leftMaxArr[i] = leftMax;
            }

            for(int i = height.length - 1; i >= 0; i--) {
                if(rightMax < height[i]) {
                    rightMax = height[i];
                }

                rightMaxArr[i] = rightMax;
            }

            int totalWater = 0;

            for(int i = 0; i < height.length; i++) {
                int curr = height[i];
                int left = leftMaxArr[i];
                int right = rightMaxArr[i];

                if(curr < left && curr < right) {
                    totalWater+= Math.min(left, right) - curr;
                }
            }

            return totalWater;
        }
    }
}
