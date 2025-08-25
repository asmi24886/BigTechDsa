package com.solutions.neetcode.slidingwindow.LC3;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    // pbwkwe

    //pbwwwkef
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s.length() == 1) return 1;

            int max = 0;
            int l = 0;

            HashMap<Character, Integer> lastSeenMap = new HashMap<>();
            char[] chars = s.toCharArray();

            for(int r = 0; r < s.length(); r++) {
                char thisChar = chars[r];
                int index = lastSeenMap.getOrDefault(thisChar, -1);
                if(index != -1 && l <= index) l = index + 1;

                lastSeenMap.put(thisChar, r);
                max = Math.max(max, r - l + 1);
            }

            return max;
        }
    }


}
