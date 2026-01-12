package com.solutions.neetcode.dp.LC139;

import java.util.*;

public class WordBreak {

    // Worst case - aaaaaaaaa for [a,aa,aaa,aaaa,aaaaa] for every i upto N a matches and this creates M choices, So N fir loops each of M length => M ^ N
    // Similar to 2 for loop sof m length - M^2
    // and K (max word length) comparisons for each - so K x M^N
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            return dp_with_trie(s, wordDict);
        }

        class TrieNode {
            HashMap<Character, TrieNode> children = new HashMap<>();
            boolean isWord = false;
        }

        class Trie {
            TrieNode root;
            int MAX_LENGTH = 0;
            Trie(List<String> words) {
                root = new TrieNode();
                words.forEach(this::insert);
            }

            private void insert(String str) {
                TrieNode node = root;
                char [] chars = str.toCharArray();
                int max = 0;
                for(char c : chars) {
                    node.children.putIfAbsent(c, new TrieNode());
                    node = node.children.get(c);
                    max++;
                }

                MAX_LENGTH = Math.max(MAX_LENGTH, max);
                node.isWord = true;
            }

            boolean search(String str, int i, int j) {
                TrieNode node = root;
                while(i <= j) {
                    char c = str.charAt(i);
                    if(node.children.get(c) == null) return false;
                    node = node.children.get(c);
                    i++;
                }

                return node.isWord;
            }
        }


        boolean dp_with_trie(String s, List<String> wordDict) {
            Trie trie = new Trie(wordDict);

            boolean [] dp = new boolean[s.length()+1];
            dp[0] = true;

            for(int i = 1; i <= s.length(); i++) {
                int start = i - 1;

                if(!dp[start]) continue;

                for(int j = i; j <= s.length(); j++) {

                    if(trie.MAX_LENGTH < j - start)
                        break;
                    if(dp[j]) continue;
                    dp[j] = trie.search(s, start, j -1);
                }
            }

            /** Alternate solution (better) -> Neetcode
                for (int i = n - 1; i >= 0; i--) {
                    for (int j = i; j < Math.min(n, i + maxLen); j++) {
                        if (trie.search(s, i, j)) {
                            dp[i] = dp[j + 1];
                            if (dp[i]) break;
                        }
                    }
                 }

                  return dp[0];
             */
            return dp[dp.length-1];
        }

        /**********************************************************************************/
        // K * M * N
        boolean dp2(String s, List<String> wordDict) {
            boolean [] dp = new boolean[s.length()];

            int i = 0;
            while(i < s.length()) {

                for(String word: wordDict) {
                    int p = Math.min(i+word.length() - 1, s.length()-1);
                     boolean match = s.substring(i, p).equals(word);
                     if(match) { dp[p] = true; }

                     if(dp[s.length() - 1]) return true;
                }

                while(i < s.length() && !dp[i]) {
                    i++;
                }

                i++;
            }

            return false;
        }

        boolean dp1(String s, List<String> wordDict) {
            //"appleenapple";

            boolean [] dp = new boolean[s.length() + 1];
            Set<String> words = new HashSet<>(wordDict);
            int MAX_WORD_LENGTH = wordDict.stream().map(String::length).max(Comparator.naturalOrder()).get();
            dp[0] = true;

            for (int i = 1; i <= s.length(); i++) {
                if(!dp[i-1]) continue;

                int start = i-1;

                for (int j = i; j <= s.length(); j++) {

                    if(j - start > MAX_WORD_LENGTH)
                        break;

                    dp[j] = dp[j] || words.contains(
                            s.substring(start, j)
                    );

                }
            }

            return dp[s.length()];
        }
    }

}
