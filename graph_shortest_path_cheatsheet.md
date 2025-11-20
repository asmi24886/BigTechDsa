# Shortest Path Algorithms for Different Graph Types

## Undirected Graphs

| Graph Type | Best Algorithm | Time Complexity | Notes |
|------------|---------------|-----------------|-------|
| Unweighted | BFS | O(V + E) | Optimal choice - simplest and fastest |
| Weighted, non-negative | Dijkstra's | O((V + E) log V) | Use with priority queue/heap |
| Weighted, with negative edges | Bellman-Ford | O(VE) | Can detect negative cycles |
| Acyclic (Tree) | BFS or DFS | O(V + E) | Any traversal works; trees have no cycles |
| Weighted Acyclic | DFS + DP | O(V + E) | Topological sort not needed (can use any order) |

## Directed Graphs

| Graph Type | Best Algorithm | Time Complexity | Notes |
|------------|---------------|-----------------|-------|
| Unweighted | BFS | O(V + E) | Same as undirected |
| Weighted, non-negative | Dijkstra's | O((V + E) log V) | Most common case |
| Weighted DAG | Topological Sort + DP | O(V + E) | Faster than Dijkstra for DAGs |
| Weighted, with negative edges (no negative cycles) | Bellman-Ford | O(VE) | Slower but handles negatives |
| With negative cycles | Bellman-Ford (for detection) | O(VE) | No shortest path exists if reachable from source |

## Key Decision Points

Start with these questions:

1. Negative edges? 
   - No → Use Dijkstra's (weighted) or BFS (unweighted)
   - Yes → Use Bellman-Ford

2. Is it a DAG?
   - Yes → Use Topological Sort + DP (fastest for weighted DAGs)

3. Unweighted?
   - Yes → Always use BFS

4. All-pairs shortest paths needed?
   - Use Floyd-Warshall O(V³) or run Dijkstra/Bellman-Ford from each vertex

## Quick Reference

- 99% of real-world cases: Dijkstra's algorithm (non-negative weights)
- Simplest case: BFS (unweighted graphs)
- Negative weights: Bellman-Ford
- DAG optimization: Topological sort + relaxation
- Detecting negative cycles: Bellman-Ford (run V iterations, if distances change on Vth iteration, negative cycle exists)

Note: For undirected graphs with negative edges, be careful - negative edge weights often imply negative cycles (back-and-forth on the same edge), making shortest paths undefined.
