package com.solutions.neetcode.graph.LC133;

import java.util.;

public class CloneGraph {

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }


    static class Solution {
        public Node cloneGraph(Node node) {
            if(node == null)
                return null;
            if(node.neighbors == null || node.neighbors.isEmpty()) {
                return new Node(node.val, new ArrayList<>());
            }
            Map<Integer, Node> visited = new HashMap<>();
            return copyNode(node, visited);
        }

        private Node copyNode(Node node, Map<Integer, Node> visited) {

            Node _node = new Node(node.val, new ArrayList<>());
            visited.put(node.val, _node);

            for(Node originalNeighbour : node.neighbors) {
                Node visitedAndCopiedNeighbour = visited.get(originalNeighbour.val);

                if(visitedAndCopiedNeighbour == null) {
                    _node.neighbors.add(copyNode(originalNeighbour, visited));
                }
                else {
                    _node.neighbors.add(visitedAndCopiedNeighbour);
                }
            }

            return _node;
        }
    }
}
