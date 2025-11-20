package com.solutions.neetcode.intervals.LC57;

import java.util.*;

public class InsertInterval {
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {

            List<int []> res = new ArrayList<>();
            boolean intervalProcessed = false;

            for(int [] i : intervals) {
                // interval after current slot, let this one pass and get added
                if(i[1] < newInterval[0]) {
                    res.add(i);
                    continue;
                }

                //interval is before current slot and is not processed yet [interval was surely after the previous one]
                if(!intervalProcessed && i[0] > newInterval[1]) { // a check for processisng is required else new interval will be multiple times
                    res.add(newInterval);
                    intervalProcessed = true;
                }

                if(intervalProcessed) {
                    res.add(i);
                    continue;
                }


                //Merge incoming to new (make it a bigger buffed interval) and wait for next loop for fitting in
                /*
                    Example

                    new - [5, 9]
                    array - [[0,2], [3, 6], [11, 14]]

                   loop 1:
                      - at stage 1 new interval is clearly after current so [0, 2] is inserted -> [[0,2]]
                      - [3, 6] comes in and we see 3,6 and 5,9 can be merged; we merge them into new interval which becomes 3,9 and we wait for next loop
                      - incoming [11, 14]; at stage 2 we see 11 greater than 9, so the modified new interval can be fit in here and is inserted -> [[0,2], [3,9], [11,14]]
                 */
                newInterval[0] = Math.min(newInterval[0], i[0]);
                newInterval[1] = Math.max(newInterval[1], i[1]);

            }

            if(!intervalProcessed) res.add(newInterval);
            return res.toArray(new int [res.size()][2]);
        }
    }
}
