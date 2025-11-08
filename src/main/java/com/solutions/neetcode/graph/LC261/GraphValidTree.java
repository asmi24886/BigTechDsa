package com.solutions.neetcode.graph.LC261;

import java.util.ArrayList;
import java.util.List;

public class GraphValidTree {

    class Solution {
        List<List<Integer>> adj = new ArrayList<>();
        //boolean [] visiting;
        boolean [] visited;
        int SIZE;
        public boolean validTree(int n, int[][] edges) {

            //setup
            SIZE = n;
            visited = new boolean[SIZE];
            //visiting = new boolean[SIZE];
            for(int i = 0; i < SIZE; i++) {
                adj.add(new ArrayList<>());
            }

            //create adj and group neighbours
            for(int [] edge : edges) {
                adj.get(edge[0]).add(edge[1]);
                adj.get(edge[1]).add(edge[0]);
            }

            if(!dfs(0, -1)) return false;

            for(boolean flag : visited) if(!flag) return false;
            return true;
        }

        boolean dfs(int node, int parent) {
            visited[node] = true;
            List<Integer> neighbours = adj.get(node);

            for(int n : neighbours) {
                if(n == parent) continue;
                if(visited[n]) return false;
                if(!dfs(n, node)) return false;
            }

            return true;
        }
    }

}
