package com.solutions.neetcode.greedy.LC763;

import java.util.*;

public class PartitionLabels {

    public static void main(String [] args) {
        System.out.println(new Solution().partitionLabels("ababcbacadefegdehijhklij"));
    }
    
    static class Solution {
        public class Range {
            int start = 0;
            int end = 0;
            public Range(int s, int e) {
                start = s;
                end = e;
            }

            @Override
            public String toString() {
                return "Range{" +
                        "start=" + start +
                        ", end=" + end +
                        '}';
            }
        }

        public List<Integer> partitionLabels(String s) {
            Map<Character, Range> map = new LinkedHashMap<>();

            char [] chars = s.toCharArray();

            int i  = 0;
            for(char c : chars) {

                Range r = map.getOrDefault(c, new Range(s.length(),0));

                r.start = Math.min(r.start, i);
                r.end = Math.max(r.end, i);

                map.put(c, r);
                i++;
            }
            
            int startIndex = -1;
            int endIndex = -1;
            int cutSum = 0;

            List<Integer> cuts = new ArrayList<>();
            System.out.println(map);
            for(Range r : map.values()) {
                if(startIndex == -1 && endIndex == -1) {
                    startIndex = r.start;
                    endIndex = r.end;
                    continue;
                }

                if(r.start < endIndex) {
                    endIndex = Math.max(r.end, endIndex);
                }
                else {
                    int count = endIndex - startIndex +1;
                    cuts.add(count);
                    cutSum+= count;
                    startIndex = r.start;
                    endIndex = r.end;
                }
            }

            if(s.length() - cutSum > 0) {
                cuts.add(s.length() - cutSum);
            }

            return cuts;
        }
    }
}
