package com.solutions.neetcode.arrayandhashing.LC14;

public class LongestCommonPrefix {

    class Solution {
        public String longestCommonPrefix(String[] strs) {
            StringBuilder longest = new StringBuilder();

            String shortest = strs[0];

            for(int i=1; i < strs.length; i++) {
                if(strs[i].length() < shortest.length())
                    shortest = strs[i];
            }

            if(shortest.isEmpty())
                return "";

            for(int i=0; i<shortest.length(); i++) {

                for(int j = 0; j < strs.length; j++) {
                    if(shortest.charAt(i) != strs[j].charAt(i))
                        return longest.toString();
                }

                longest.append(shortest.charAt(i));
            }
            return longest.toString();

        }
    }
}
