package com.solutions.neetcode.trie.LC211;

import java.util.HashMap;

public class DesignAddAndSearchWordDataStructure {
    class WordDictionary {
        class TrieNode {
            HashMap<Character, TrieNode> nodes = new HashMap<>();
            boolean endOfWord = false;
        }
        TrieNode root;
        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            char [] chars = word.toCharArray();
            TrieNode node = root;

            for(char c: chars) {
                node.nodes.putIfAbsent(c, new TrieNode());
                node = node.nodes.get(c);
            }

            node.endOfWord = true;
        }

        public boolean search(String word) {
            return dfs(root, word.toCharArray(), 0);
        }

        boolean dfs(TrieNode node, char [] searchWord, int idx) {
            if(idx == searchWord.length) return node.endOfWord;

            char cur_char = searchWord[idx];

            if(cur_char == '.') {
                for(TrieNode n : node.nodes.values()) {
                    if(dfs(n, searchWord, idx++)) return true;
                }
            }
            else {
                if(node.nodes.containsKey(cur_char)) {
                    return dfs(node.nodes.get(cur_char), searchWord, idx++);
                }
            }

            return false;
        }
    }
}
