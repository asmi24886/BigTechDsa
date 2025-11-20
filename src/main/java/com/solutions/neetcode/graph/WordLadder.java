package com.solutions.neetcode.graph;

import java.util.;

public class WordLadder {

    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if(!wordList.contains(endWord)) return 0;
            if(!wordList.contains(beginWord)) wordList.add(beginWord);

            Map<Integer, List<Integer>> adj = new HashMap<>();

            // create adj list undirected
            for(int i = 0; i < wordList.size(); i++) {
                adj.putIfAbsent(i, new ArrayList<>());
                String thisWord = wordList.get(i);

                for(int j = i+1; j < wordList.size(); j++) {
                    String nextWord = wordList.get(j);
                    if(diffByOne(thisWord, nextWord)) {
                        adj.get(i).add(j);
                        adj.putIfAbsent(j, new ArrayList<>());
                        adj.get(j).add(i);
                    }
                }
            }

            boolean [] visited = new boolean[wordList.size()];
            Queue<Integer> queue = new LinkedList<>();

            int idx_begin_word = wordList.indexOf(beginWord);
            visited[idx_begin_word] = true;
            queue.add(idx_begin_word);

            int steps = 0;

            while (!queue.isEmpty()) {
                int size = queue.size();
                steps++;

                for(int i = 0; i < size; i++) {
                    int idx = queue.poll();
                    if(wordList.get(idx).equals(endWord)) return steps;

                    List<Integer> list = adj.get(idx);
                    for(int nei_idx : list) {
                        if(visited[nei_idx]) continue;
                        visited[nei_idx] = true;
                        queue.offer(nei_idx);
                    }
                }
            }

            return 0;

        }

        boolean diffByOne(String str1, String str2) {
            char [] s1 = str1.toCharArray();
            char [] s2 = str2.toCharArray();

            int mismatches = 0;
            for(int i = 0; i < s1.length; i++) {
                if(s1[i] != s2[i]) {
                    mismatches++;
                    if(mismatches == 2) return false;
                }
            }
            return mismatches == 1;
        }
    }
}
