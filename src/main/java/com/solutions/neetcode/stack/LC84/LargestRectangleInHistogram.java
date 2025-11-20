package com.solutions.neetcode.stack.LC84;

import java.util.Stack;

public class LargestRectangleInHistogram {
    class Solution {

        public int largestRectangleArea(int[] heights) {

            int maxArea = 0;

            Stack<Integer> indexStack = new Stack<>();

            for(int i = 0; i < heights.length; i++) {

                while (!indexStack.isEmpty() && heights[indexStack.peek()] > heights[i]) {
                    int topIndex = indexStack.pop();

                    int width = 1;
                    if(indexStack.isEmpty()) {
                        width = i;
                    }
                    else {
                        width = i - indexStack.peek() - 1;
                    }

                    maxArea = Math.max(maxArea, heights[topIndex]width);
                }

                indexStack.push(i);
            }

            //calculate remaining area
            while(!indexStack.isEmpty()) {
                int topIndex = indexStack.pop();
                int width = 1;
                if(indexStack.isEmpty()) {
                    width = heights.length;
                }
                else {
                    width = heights.length - indexStack.peek() - 1;
                }

                maxArea = Math.max(maxArea, heights[topIndex]  width);
            }
            return maxArea;
        }
    }
}
