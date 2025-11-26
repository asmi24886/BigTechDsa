package com.solutions.neetcode.intervals.LC253;

import java.util.List;

public class MeetingRooms2 {
// [[0,20], [5, 18], [21-35]]
    class Solution {
        public int minMeetingRooms(List<Interval> intervals) {
            int maxTime = -1;

            for(Interval i : intervals) {
                maxTime = Math.max(i.end, maxTime);
            }

            int [] times = new int[maxTime + 1];

            int maxConflict = 0;

            for(Interval i : intervals) {
                times[i.start] = times[i.start] + 1;
                times[i.end] = times[i.end] - 1;
            }

            int conflicts = 0;
            for(int c : times) {
                conflicts+=c;
                maxConflict = Math.max(maxConflict, conflicts);
            }
            return maxConflict;
        }

        class Interval {
            public int start, end;

            public Interval(int start, int end) {
                this.start = start;
                this.end = end;
            }
        }
    }

}
