package com.solutions.neetcode.arrayandhashing.LC49;

import java.util.;
import java.util.stream.Collectors;

public class GroupAnagrams {

    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            return Arrays.stream(strs).collect(Collectors.groupingBy(
                    s -> {
                        char[] chars = s.toCharArray();
                        Arrays.sort(chars);
                        return new String(chars);
                    },
                    Collectors.toList()
            )).values().stream().toList();
        }

        public List<List<String>> groupAnagramsOptimized(String[] strs) {
            HashMap<String, List<String>> map = new HashMap<>();
            for (String s : strs) {
                int[] charNos = new int[26];
                char[] chars = s.toCharArray();
                for (char c : chars) {
                    charNos[Character.toLowerCase(c) - 'a']++;
                }

                String hash = Arrays.toString(charNos);
                map.putIfAbsent(hash, new ArrayList<>());
                map.get(hash).add(s);
            }

            return map.values().stream().toList();
        }

    }
}
