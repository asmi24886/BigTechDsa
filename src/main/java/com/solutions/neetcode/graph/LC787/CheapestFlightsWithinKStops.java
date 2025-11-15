package com.solutions.neetcode.graph.LC787;

import java.util.*;

public class CheapestFlightsWithinKStops {

    class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            List<List<int[]>> adj = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }

            for(int[] f : flights) {
                adj.get(f[0]).add(new int[]{f[1], f[2]});
            }

            // Track minimum cost to reach each node with at most j stops
            int[][] minCost = new int[n][k + 2];
            for(int i = 0; i < n; i++) {
                Arrays.fill(minCost[i], Integer.MAX_VALUE);
            }

            // PQ: {node, cost, stops}
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            pq.offer(new int[]{src, 0, 0});
            minCost[src][0] = 0;

            int MAX_ALLOWED_STEPS = k + 1;
            while(!pq.isEmpty()) {
                int[] curr = pq.poll();
                int node = curr[0], cost = curr[1], stops = curr[2];

                if(node == dst) return cost;
                if(stops == MAX_ALLOWED_STEPS) continue;

                // Skip if we've already found a better path to this node with these stops
                if(cost > minCost[node][stops]) continue;

                for(int[] next : adj.get(node)) {
                    int nextNode = next[0], price = next[1];
                    int newCost = cost + price;
                    int updatedStops = stops + 1;

                    if(newCost < minCost[nextNode][updatedStops]) {
                        minCost[nextNode][updatedStops] = newCost;
                        pq.offer(new int[]{nextNode, newCost, updatedStops});
                    }
                }
            }

            return -1;
        }
    }
}
