package com.solutions.neetcode.slidingwindow.LC567;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PermutationInString {

    class Solution {
        public boolean checkInclusion(String s1, String s2) {

            if(s1.isBlank() || s2.isBlank()) return false;
            if(s1.length() > s2.length()) return false;

            return frequencyCountApproach(s1, s2);
        }

        public boolean frequencyCountApproach(String s1, String s2) {

            int [] s1Count = new int[26];
            int [] s2Count = new int[26];
            int matches = 0;

            for(int i =0; i < s1.length(); i++) {
                s1Count[s1.charAt(i) - 'a']+=1;
                s2Count[s2.charAt(i) - 'a']+=1;
            }

            for(int i = 0; i < 26; i++) {
                if(s1Count[i] == s2Count[i])
                    matches++;
            }

            for(int r = s1.length(), l = 0; r < s2.length(); r++) {
                if(matches == 26) return true;  // check current window first

                int incoming = s2.charAt(r) - 'a';
                s2Count[incoming]++;
                if(s2Count[incoming] == s1Count[incoming]) matches++;
                else if(s2Count[incoming] == s1Count[incoming] + 1) matches--;

                int outgoing = s2.charAt(l) - 'a';
                s2Count[outgoing]--;
                if(s2Count[outgoing] == s1Count[outgoing]) matches++;
                else if(s2Count[outgoing] == s1Count[outgoing] - 1) matches--;

                l++;
            }
            return matches == 26;
        }

        public boolean twoMapApproach(String s1, String s2) {

            Map<Character, Integer> s1CharCount = new HashMap<>();
            char [] chars = s1.toCharArray();
            for(char c: chars) {
                s1CharCount.put(c, s1CharCount.getOrDefault(c, 0) + 1);
            }
            int need = s1CharCount.size();
            for(int i = 0; i < s2.length(); i++) {
                int curr = 0;
                Map<Character, Integer> s2CharCount = new HashMap<>();
                for(int j = i; j < s2.length(); j++) {

                    char thisChar = s2.charAt(j);
                    s2CharCount.put(thisChar, s2CharCount.getOrDefault(thisChar, 0)+1);

                    if(s1CharCount.getOrDefault(thisChar, 0) < s2CharCount.get(thisChar)) break;

                    if(Objects.equals(s1CharCount.get(thisChar), s2CharCount.get(thisChar))) curr++;

                    if(curr == need)
                        return true;
                }
            }

            return false;
        }

        public boolean mapCompareApproach(String s1, String s2) {
            HashMap<Character, Integer> countMap = new HashMap<>();

            char[] chars = s1.toCharArray();
            for(char c : chars) {
                countMap.put(c, countMap.getOrDefault(c, 0) + 1);
            }

            int l = 0;

            for(int r = s1.length() - 1; r < s2.length(); r++, l++) {
                char startChar = s2.charAt(l);
                char endChar = s2.charAt(r);

                if(countMap.get(startChar) == null || countMap.get(endChar) == null) {
                    continue;
                }

                HashMap<Character, Integer> tempMap = new HashMap<>();
                for(int cur = l; cur <= r; cur++) {
                    char thisChar = s2.charAt(cur);
                    if(countMap.get(thisChar) == null) {
                        l = cur;
                        r = l + s1.length() - 1;
                        break;
                    }

                    tempMap.put(thisChar, tempMap.getOrDefault(thisChar, 0) + 1);
                }

                if(tempMap.equals(countMap)) return true;
            }

            return false;
        }
    }
}
