package com.solutions.neetcode.arrayandhashing.LC953;

import java.util.HashMap;
import java.util.Map;

public class VerifyingAnAlienDictionary {
    public static void main(String [] args) {
        Solution sol = new Solution();
        String [] words1 = {"hello","leetcode"};
        String [] words2 = {"word","world","row"};
        String [] words3 = {"apple","app"};

        System.out.println(sol.isAlienSorted(words1, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(sol.isAlienSorted(words2, "worldabcefghijkmnpqstuvxyz"));
        System.out.println(sol.isAlienSorted(words3, "abcdefghijklmnopqrstuvwxyz"));

    }

    static class Solution {
        public boolean isAlienSorted(String[] words, String order) {

            Map<Character, Integer> map = new HashMap<>();
            char [] orderArray = order.toCharArray();
            int orderCount = 1;
            for(char c : orderArray) {
                map.put(c, orderCount++);
            }

            for(int i = 0; i < words.length-1; i++) {
                if(!isSorted(words[i].toCharArray(), words[i+1].toCharArray(), map)) return false;
            }
            return true;
        }

        public boolean isSorted(char [] word1, char [] word2, Map<Character, Integer> order) {

            int length = Math.max(word1.length, word2.length);

            for(int i = 0; i < length; i++) {
                int order1 = -1;
                int order2 = -1;

                if(i < word1.length) {
                    order1 = order.get(word1[i]);
                }

                if(i < word2.length) {
                    order2 = order.get(word2[i]);
                }

                if(order1 < order2) return true;
                if(order1 > order2) return false;
            }

            return true;
        }
    }
}
