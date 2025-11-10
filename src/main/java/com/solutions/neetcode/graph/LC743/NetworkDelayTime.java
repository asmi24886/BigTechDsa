package com.solutions.neetcode.graph.LC743;

import java.util.*;

//MODIFED DIJKSTRA
public class NetworkDelayTime {

    class Solution {
        int SIZE;
        Map<Integer, List<int[]>> adj = new HashMap<>();
        boolean [] visited;
        //int [] cost;
        PriorityQueue<int []> pq = new PriorityQueue<>(Comparator.comparing((int [] n) -> n[1]));

        public int networkDelayTime(int[][] times, int n, int k) {
            SIZE=n;
            visited = new boolean[SIZE+1];
            //cost = new int[SIZE+1];

            for(int i=1; i<=SIZE;i++) {
                adj.put(i, new ArrayList<>());
                //cost[i] = Integer.MAX_VALUE;
            }

            for(int [] t : times) {
                adj.get(t[0]).add(new int[] {t[1], t[2]});
            }

            //cost[k] = 0;
            pq.offer(new int []{k, 0});
            int minCost = 0;
            int processed = 0;
            while(!pq.isEmpty()) {
                int [] node = pq.poll();
                if(visited[node[0]]) continue;
                visited[node[0]] = true;
                processed++;
                minCost = node[1];
                List<int []> nei = adj.get(node[0]);

                for(int [] ne : nei) {
                    if(visited[ne[0]]) continue;
                    pq.offer(new int [] {ne[0], ne[1] + node[1]});
                }
            }

            return (n == processed? minCost : -1);
        }

    }
}
