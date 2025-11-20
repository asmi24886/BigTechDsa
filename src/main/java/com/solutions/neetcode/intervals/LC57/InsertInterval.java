package com.solutions.neetcode.intervals.LC57;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InsertInterval {
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {

            List<int []> list = new ArrayList<>();
            boolean intervalProcessed = false;
            for(int [] i : intervals) {
                if(newInterval[0] <= i[0] && !intervalProcessed) {
                    list.add(newInterval);
                    intervalProcessed = true;
                }

                list.add(i);
            }

            if(list.isEmpty() || list.size() == intervals.length) list.add(newInterval);

            Stack<int []> stack = new Stack<>();
            for(int [] i : list) {
                if(stack.isEmpty()) {
                    stack.push(i);
                    continue;
                }

                int [] lastInterval = stack.peek();

                if(lastInterval[1] >= i[0]) {
                    if(lastInterval[1] < i[1])
                        lastInterval[1] = i[1]; //else do nothing as it already falls in the prev interval
                }
                else {
                    stack.push(i);
                }
            }

            int [][] res = new int[stack.size()][2];

            for(int i = res.length-1; i >= 0; i--) {
                int [] interval = stack.pop();
                res[i] = interval;
            }
            return res;
        }
    }
}
