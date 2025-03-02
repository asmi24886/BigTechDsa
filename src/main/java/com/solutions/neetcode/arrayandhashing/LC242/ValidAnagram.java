package com.solutions.neetcode.arrayandhashing.LC242;

import java.util.HashMap;

public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println( isAnagram("anagram", "nagaram") );
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        HashMap<Character, Integer> countMap = new HashMap<>();

        for(char c: sArray) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        for(char c: tArray) {
            countMap.put(c, countMap.getOrDefault(t, 0) - 1);
            if(countMap.get(c) < 0) return false; //Nice trick
        }

        return true;
    }
}
