package com.solutions.neetcode.intervals.LC252;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MeetingRooms {
    class Solution {
        public class Interval {
          public int start, end;
          public Interval(int start, int end) {
              this.start = start;
              this.end = end;
          }
        }

        public boolean canAttendMeetings(List<Interval> intervals) {
            Collections.sort(intervals, Comparator.comparing((Interval i) -> i.start));

            int lastEndTime = -1;
            for(Interval i : intervals) {
                if(i.start < lastEndTime) {
                    return false;
                }
                lastEndTime = i.end;
            }

            return true;
        }
    }
}
