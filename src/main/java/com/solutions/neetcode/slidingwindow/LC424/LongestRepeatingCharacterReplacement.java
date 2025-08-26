package com.solutions.neetcode.slidingwindow.LC424;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class LongestRepeatingCharacterReplacement {

    //KGGGAAABCBBADEE

    //AAHAAGGH

    //KGGGABCDE / 2
    class Solution {

        public int characterReplacement(String s, int k) {

            HashMap<Character, Integer> countMap = new HashMap<>();
            char [] chars = s.toCharArray();
            int max = 0;
            int l = 0;
            int highestCommonCount = 1;
            for(int r = 0; r < chars.length; r++) {

                countMap.put(chars[r], countMap.getOrDefault(chars[r], 0) + 1);

                //This is a great trick. take note, once the highest common count is set, the window is adjusted and the next common count can be greater than this but not lesser
                //So commons + k+1 = window => bigger window = bigger common; if not then dont bother with any computation
                //this is to avoid reaching out for highest count from map. IDEA is to find the window with highest common count and then do computation else dont bother
                highestCommonCount = Math.max(highestCommonCount, countMap.get(chars[r]));

                while(r - l + 1 - highestCommonCount > k) {
                    countMap.put(chars[l], countMap.get(chars[l]) - 1);
                    l++;
                }

                max = Math.max(r - l + 1, max);
            }

            return max;
        }

        public int characterReplacement_brute(String s, int k) {

            char [] chars = s.toCharArray();
            int max = 0;
            HashSet<Character> set = new HashSet<>();
            for(char c : chars) {set.add(c);}

            for(char c : set) {
                int l = 0;
                int rc = 0;

                for(int r = 0; r < chars.length; r++) {

                    if(chars[r] != c) {
                        rc++;
                    }

                    while(rc > k) {

                        if(chars[l] != c) {
                            rc --;
                        }

                        l++;
                    }

                    max = Math.max(r - l + 1, max);
                }

            }

            return max;
        }
    }
}
