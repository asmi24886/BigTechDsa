package com.solutions.neetcode.graph.LC269;

import java.net.Inet4Address;
import java.util.;

public class AlienDictionary {

    class Solution {

        Set<Character> visited = new HashSet<>();
        Set<Character> visiting = new HashSet<>();
        Map<Character, List<Character>> adj = new HashMap<>();
        Stack<Character> stack = new Stack<>();

        public String foreignDictionary(String[] words) {

            // Setup
            for(String word: words) {
                char [] chars = word.toCharArray();

                for(char c : chars) {
                    adj.putIfAbsent(c, new ArrayList<>());
                }
            }
            for(int i = 0; i < words.length - 1; i ++) {
                String word1 = words[i];
                String word2 = words[i+1];

                int length = Math.min(word1.length(), word2.length());

                if (word1.length() > word2.length() &&
                        word1.substring(0, length).equals(word2.substring(0, length))) return ""; // aaab and aaa is invalid because how do we determine which one should have come first

                for(int j = 0; j < length; j ++) {
                    char w1c = word1.charAt(j);
                    char w2c = word2.charAt(j);
                    if(w1c != w2c) {
                        adj.get(w1c).add(w2c);
                        break;
                    }
                }
            }

            for(char c: adj.keySet()) {
                if(!dfs(c)) return "";
            }

            StringBuilder builder = new StringBuilder();
            while (!stack.isEmpty()) {
                builder.append(stack.pop());
            }
            return builder.toString();
        }

        boolean dfs(char c) {
            if(visiting.contains(c)) return false;
            if(visited.contains(c)) return true; // already marked as safe

            visiting.add(c);

            List<Character> list = adj.get(c);

            for(char nei : list) {
                if(!dfs(nei)) return false;
            }

            visiting.remove(c);

            stack.push(c);
            visited.add(c);
            return true;
        }
    }

    class Solution2_KAHNS {

        Map<Character, List<Character>> adj = new HashMap<>();
        Map<Character, Integer> inDegrees = new HashMap<>();


        public String foreignDictionary(String[] words) {

            // Setup
            for(String word: words) {
                char [] chars = word.toCharArray();

                for(char c : chars) {
                    adj.putIfAbsent(c, new ArrayList<>());
                    inDegrees.putIfAbsent(c, 0);
                }
            }
            for(int i = 0; i < words.length - 1; i ++) {
                String word1 = words[i];
                String word2 = words[i+1];

                int length = Math.min(word1.length(), word2.length());

                if (word1.length() > word2.length() &&
                        word1.substring(0, length).equals(word2.substring(0, length))) return ""; // aaab and aaa is invalid because how do we determine which one should have come first

                for(int j = 0; j < length; j ++) {
                    char w1c = word1.charAt(j);
                    char w2c = word2.charAt(j);
                    if(w1c != w2c) {
                        adj.get(w1c).add(w2c);
                        inDegrees.put(w2c, inDegrees.get(w2c) + 1);
                        break;
                    }
                }
            }

            Queue<Character> queue = new LinkedList<>();
            StringBuilder builder = new StringBuilder();

            for(Map.Entry<Character, Integer> e : inDegrees.entrySet()) {
                if(e.getValue() == 0) queue.offer(e.getKey());
            }

            while (!queue.isEmpty()) {
                char c = queue.poll();
                builder.append(c);

                List<Character> list = adj.get(c);
                for(char nei: list) {
                    inDegrees.put(nei, inDegrees.get(nei) - 1);
                    if(inDegrees.get(nei) == 0) {
                        queue.add(nei);
                    }
                }
            }

            if(builder.length() != adj.size()) return "";
            return builder.toString();
        }
    }
}
