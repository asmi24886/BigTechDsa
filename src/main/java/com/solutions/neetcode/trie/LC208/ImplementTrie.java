package com.solutions.neetcode.trie.LC208;

import java.util.HashMap;

public class ImplementTrie {

    class TrieNode {
        HashMap<Character, TrieNode> nodes = new HashMap<>();
        boolean endOfWord = false;
    }
    class Trie {
        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {

            char [] chars = word.toCharArray();
            TrieNode trieNode = root;
            for(char c : chars) {
                trieNode.nodes.putIfAbsent(c, new TrieNode());
                trieNode = trieNode.nodes.get(c);
            }

            trieNode.endOfWord = true;
        }

        public boolean search(String word) {
            char [] chars = word.toCharArray();
            TrieNode trieNode = root;
            for(char c : chars) {
                if(!trieNode.nodes.containsKey(c)) return false;
                trieNode = trieNode.nodes.get(c);
            }

            return trieNode.endOfWord;
        }

        public boolean startsWith(String prefix) {
            char [] chars = prefix.toCharArray();
            TrieNode trieNode = root;
            for(char c : chars) {
                if(!trieNode.nodes.containsKey(c)) return false;
                trieNode = trieNode.nodes.get(c);
            }

            return true;
        }
    }

/
  Your Trie object will be instantiated and called as such:
  Trie obj = new Trie();
  obj.insert(word);
  boolean param_2 = obj.search(word);
  boolean param_3 = obj.startsWith(prefix);
 /
}
