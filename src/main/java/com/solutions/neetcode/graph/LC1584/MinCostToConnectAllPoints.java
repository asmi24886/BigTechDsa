package com.solutions.neetcode.graph.LC1584;

import java.util.;

//Good to also check out the optimal version of Prim's on neetcode
public class MinCostToConnectAllPoints {

    class Solution {
        int SIZE;
        boolean [] visited;

        Map<Integer, int[]> pointsMap = new HashMap<>();
        List<List<int []>> adj = new ArrayList<>();
        PriorityQueue<int []> pq = new PriorityQueue<>(Comparator.comparing((int [] i) -> i[1]));

        public int minCostConnectPoints(int[][] points) {

            SIZE = points.length;
            visited = new boolean[SIZE];

            for(int i = 0; i < SIZE; i++) {
                pointsMap.put(i, points[i]);
                adj.add(i, new ArrayList<>());
            }

            for(int i = 0; i < SIZE; i++) {
                for(int j = 0; j < SIZE; j ++) {
                    if(i == j) continue;
                    adj.get(i).add(getConnectedEdge(i, j));
                }
            }

            int minCost = 0;
            int processed = 0;

            pq.offer(new int [] {0, 0});

            while(!pq.isEmpty()) {

                int [] node = pq.poll();
                if(visited[node[0]]) continue;

                visited[node[0]] = true;
                processed++;
                minCost+= node[1];

                List<int []> nei = adj.get(node[0]);

                for(int [] n : nei) {
                    if(visited[n[0]]) continue;
                    pq.offer(n);
                }

                if(processed == SIZE) return minCost;
            }

            return 0;
        }

        int [] getConnectedEdge(int node1, int node2) {
            int[] point1 = pointsMap.get(node1);
            int[] point2 = pointsMap.get(node2);

            int distance = Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);

            return new int []{node2, distance};
        }
    }
}
