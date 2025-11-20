package com.solutions.neetcode.graph.LC787;

import java.util.*;

public class CheapestFlightsWithinKStops {

    // BFS with pruning
    class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            List<List<int[]>> adj = new ArrayList<>();
            int [] costs = new int[n];

            Arrays.fill(costs, Integer.MAX_VALUE);

            for(int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }

            for(int[] f : flights) {
                adj.get(f[0]).add(new int[]{f[1], f[2]});
            }

            Queue<int []> queue = new LinkedList<>();
            queue.add(new int []{src, 0, 0});

            while(!queue.isEmpty()) {
                int [] item = queue.poll();
                int node = item[0], steps = item[1], cost = item[2];

                if(steps > k) continue;

                List<int []> list = adj.get(node);

                for(int [] nei : list) {

                    int updatedCost = cost + nei[1];
                    if(updatedCost < costs[nei[0]]) {
                        costs[nei[0]] = updatedCost;
                        queue.add(new int[] {nei[0], steps+1, updatedCost});
                    }
                }
            }

            return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];
        }
    }
    // modified bellman ford
    /*
    [[1,0,5],[2,1,5],[3,0,2],[1,3,2],[4,1,1],[2,4,1]]

    loop 1:
    og = [i, i, 0, i, i]
    tmp = [i, 5, 0, i, 1 ]

    loop 2:
    og = [i, 5, 0, i, 1 ]
    tmp = [10, 2, 0, 7, 1]

    loop 3:
    og = [10, 2, 0, 7, 1]
    tmp = [7, 2, 0, 7, 1] 9 gets updated instead of 7 for 3,0,2 if are checking old values and thats wrong
     */
    class Solution2 {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

            int [] costs  = new int[n];
            Arrays.fill(costs, Integer.MAX_VALUE);
            costs[src] = 0;

            for(int i = 0; i <= k; i++) {
                int [] temp = costs.clone();
                for(int [] f : flights) {
                    int source = f[0], destination = f[1], cost = f[2];
                    if(costs[source] == Integer.MAX_VALUE) continue;

                    int updatedCost = costs[source] + cost; // ensures you are not taking a multi chain edge update, else it defeats k+1 edges purpose with 1 edge at a time
                    if( updatedCost < temp[destination] ) {
                        temp[destination] = updatedCost;
                    }
                }

                costs = temp;
            }

            return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];
        }
    }

    //Djikstras + pruning
    class Solution3 {
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

                    if(newCost >= minCost[nextNode][updatedStops]) continue;

                    minCost[nextNode][updatedStops] = newCost;
                    pq.offer(new int[]{nextNode, newCost, updatedStops});
                }
            }

            return -1;
        }
    }
}
