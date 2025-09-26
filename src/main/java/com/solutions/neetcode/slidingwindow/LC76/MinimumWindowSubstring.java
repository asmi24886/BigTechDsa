package com.solutions.neetcode.slidingwindow.LC76;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    class Solution {
        public String minWindow(String s, String t) {
            if (t.length() > s.length()) return "";

            // Frequency map for characters in t
            Map<Character, Integer> tCount = new HashMap<>();
            for (char c : t.toCharArray()) {
                tCount.put(c, tCount.getOrDefault(c, 0) + 1);
            }

            // Sliding window character frequency map
            Map<Character, Integer> windowCount = new HashMap<>();

            int have = 0; // Number of characters meeting the required count
            int need = tCount.size(); // Total unique characters to match

            int left = 0;
            int minLen = Integer.MAX_VALUE;
            int minStart = 0;

            // Expand the window with right pointer
            for (int right = 0; right < s.length(); right++) {
                char c = s.charAt(right);

                // Add current char to window count
                if (tCount.containsKey(c)) {
                    windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);

                    // Increment 'have' if the current char satisfies required count
                    if (windowCount.get(c).intValue() == tCount.get(c).intValue()) {
                        have++;
                    }
                }

                // Shrink the window from the left if all required chars are matched
                while (have == need) {
                    // Update minimum window if smaller
                    if (right - left + 1 < minLen) {
                        minLen = right - left + 1;
                        minStart = left;
                    }

                    char leftChar = s.charAt(left);

                    // Remove left char from window
                    if (tCount.containsKey(leftChar)) {
                        windowCount.put(leftChar, windowCount.get(leftChar) - 1);

                        // If window no longer satisfies required count, decrement 'have'
                        if (windowCount.get(leftChar) < tCount.get(leftChar)) {
                            have--;
                        }
                    }

                    left++; // Shrink window
                }
            }

            // If minLen was updated, return the substring, else return empty
            return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
        }
    }

}
