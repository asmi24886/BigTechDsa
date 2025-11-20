package com.solutions.neetcode.graph.LC332;

import java.util.;

public class ReconstructItinerary {

    class Solution {
        HashMap<String, PriorityQueue<String>> destMap = new HashMap<>();
        Stack<String> stack = new Stack<>();

        public List<String> findItinerary(List<List<String>> tickets) {

            for(List<String> ticket : tickets) {
                destMap.putIfAbsent(ticket.get(0), new PriorityQueue<>());
                destMap.putIfAbsent(ticket.get(1), new PriorityQueue<>());
            }

            for(List<String> ticket : tickets) {
                destMap.get(ticket.get(0)).offer( ticket.get(1) );
            }

            dfs("JFK");

            List<String> res = new ArrayList<>();

            while(!stack.isEmpty()) {
                res.add(stack.pop());
            }

            return res;
        }

        void dfs(String src) {

            PriorityQueue<String> conn = destMap.get(src);

            while(!conn.isEmpty()) {
                String dst = conn.poll();
                dfs(dst);
            }

            stack.push(src);
        }
    }
}
