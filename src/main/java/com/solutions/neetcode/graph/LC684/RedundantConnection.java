package com.solutions.neetcode.graph.LC684;

import java.util.*;

public class RedundantConnection {
    class Solution2 {
        int SIZE;
        boolean [] visited;
        Map<Integer, List<Integer>> adj = new HashMap();


        public int[] findRedundantConnection(int[][] edges) {
            SIZE = edges.length;
            for(int i = 1; i <= SIZE; i ++) {
                adj.put(i, new ArrayList<>());
            }

            for(int [] e : edges) {
                adj.get(e[0]).add(e[1]);
                adj.get(e[1]).add(e[0]);
                visited = new boolean[SIZE+1];

                if(!dfs(e[0], -1))
                    return e;
            }

            return null;
        }

        boolean dfs(int node, int parent) {
            visited[node] = true;
            List<Integer> nei = adj.get(node);

            for(int n : nei) {
                if(n == parent) continue;
                if(visited[n]) {
                    return false;
                }

                if(!dfs(n, node)) return false;
            }

            return true;
        }
    }

    class Solution {
        int SIZE;
        int [] rank;
        int [] parent;

        public int[] findRedundantConnection(int[][] edges) {
            SIZE = edges.length;
            rank = new int[SIZE+1];
            parent = new int[SIZE+1];

            for(int i = 1; i <= SIZE; i ++) {
                parent[i] = i;
            }

            for(int [] e : edges) {
                int p1 = findParent(e[0]);
                int p2 = findParent(e[1]);

                if(p1 == p2) return e;
                union(p1, p2);
            }
            return null;
        }

        void union(int p1, int p2) {
            int r1 = rank[p1];
            int r2 = rank[p2];

            if(r1 == r2) {
                parent[p2] = p1;
                rank[p1]++;
            }
            else if(r1 > r2) {
                parent[p2] = p1;
            }
            else {
                parent[p1] = p2;
            }
        }

        int findParent(int conn) {
            if(parent[conn] == conn) return conn;
            parent[conn] = findParent(parent[conn]);
            return parent[conn];
        }
    }
}
