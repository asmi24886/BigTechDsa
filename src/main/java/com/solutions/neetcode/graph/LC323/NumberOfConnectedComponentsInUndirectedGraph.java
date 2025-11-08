package com.solutions.neetcode.graph.LC323;

import java.util.ArrayList;
import java.util.List;

public class NumberOfConnectedComponentsInUndirectedGraph {

    class Solution {
        int SIZE;
        boolean [] visited;
        List<List<Integer>> adj = new ArrayList<>();
        int COUNT = 0;

        public int countComponents(int n, int[][] edges) {
            SIZE = n;
            visited = new boolean[SIZE];

            for(int i = 0; i < SIZE; i ++) {
                adj.add(new ArrayList<>());
            }

            for(int [] e : edges) {
                adj.get(e[0]).add(e[1]);
                adj.get(e[1]).add(e[0]);
            }

            for(int [] e : edges) {
                if(visited[e[0]])
                    continue;
                COUNT++;
                dfs(e[0], -1);
            }

            for(boolean flag : visited) {
                if(!flag) COUNT++;
            }

            return COUNT;
        }

        void dfs(int node, int parent) {
            visited[node] = true;
            List<Integer> neighbours = adj.get(node);

            for(int n : neighbours) {
                if(parent == n) continue;
                if(visited[n]) continue;
                dfs(n, node);
            }
        }
    }

}
