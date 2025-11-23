package com.solutions.neetcode.trie.LC212;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordSearch2 {

    // O ( m * n * 3^P-max )
    class Solution {

        char [][] board;
        Trie trie = new Trie();
        boolean [][] visit;
        int [][] directions = new int [][]{
            {0,1},
            {1, 0},
            {0, -1},
            {-1, 0}
        };

        List<String> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        public List<String> findWords(char[][] b, String[] words) {
            board = b;
            visit = new boolean[board.length][board[0].length];

            for(String word : words) {
                trie.insert(word);
            }

            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[0].length; j++) {
                    dfs(i, j, trie.root);
                }
            }

            return result;
        }

        void dfs(int i, int j, TrieNode node) {

            char c = board[i][j];
            TrieNode n = node.nodes.get(c);
            if(n == null) return;
            builder.append(c);
            visit[i][j] = true;

            if(n.endOfWord) {
                result.add(builder.toString());
                n.endOfWord = false;
            }

            for(int [] d : directions) {
                int next_i = i + d[0];
                int next_j = j + d[1];

                if( next_i >= 0 && next_i < board.length &&
                next_j >= 0 && next_j < board[0].length && !visit[next_i][next_j]) {
                    dfs(next_i, next_j, n);
                }
            }

            builder.deleteCharAt(builder.length() - 1);
            visit[i][j] = false;
        }

        class Trie {
            TrieNode root;

            Trie() {
                root = new TrieNode();
            }

            void insert(String word) {
                char [] chars = word.toCharArray();

                TrieNode node = root;

                for(int i = 0; i < chars.length; i++) {
                    node.nodes.putIfAbsent(chars[i], new TrieNode());
                    node = node.nodes.get(chars[i]);
                }

                node.endOfWord = true;
            }
        }

        class TrieNode {
            HashMap<Character, TrieNode> nodes = new HashMap<>();
            boolean endOfWord = false;
        }
    }
}
