package com.solutions.neetcode.graph.LC207;

import java.util.*;

public class CourseSchedule {
    class Solution {
        int [][] matrix;
        int SIZE;

        boolean [] path;
        boolean [] safe;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            //init
            SIZE = numCourses;
            matrix = new int [SIZE][SIZE];
            path = new boolean [SIZE];
            safe = new boolean [SIZE];

            for(int [] courses : prerequisites) {
                matrix[courses[0]][courses[1]] = 1;
            }

            for(int [] coursePair : prerequisites) {
                if(!dfs(coursePair[0])) return false;
            }

            return true;
        }

        boolean dfs(int course) {
            if(safe[course])
                return true;

            if(path[course])
                return false;

            path[course] = true;

            int [] dependencies = matrix[course];

            for(int i =0; i < SIZE; i ++) {
                if(dependencies[i] == 1) {
                    // we dont have to create new fresh set because if this has flaws then what will i even do with a subpath
                    if(!dfs(i)) return false;
                }
            }
            path[course] = false;
            safe[course] = true; // mark safe
            return true;
        }
    }

    // OPTIMIZED KAHN's TOPOLOGICAL SORT ALGO
    class Solution2 {
        Map<Integer, List<Integer>> adj =  new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        int [] inner;
        int SIZE;

        // TOPOLOGICAL SORT - DFS
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            SIZE = numCourses;
            inner = new int[SIZE];

            //Prepare adj
            for(int i = 0; i < SIZE; i++) {
                adj.putIfAbsent(i, new ArrayList<>());
            }

            for(int [] pair : prerequisites) {
                adj.get(pair[0]).add(pair[1]);
                inner[pair[1]]++;
            }

            for(int i = 0; i < SIZE; i++) {
                if(inner[i] == 0)
                    queue.offer(i);
            }

            int processed = 0;
            while(!queue.isEmpty()) {
                processed++;
                int course = queue.poll();
                List<Integer> neighbours = adj.get(course);

                for(int neighbour : neighbours) {
                    inner[neighbour]--;
                    if(inner[neighbour] == 0) queue.offer(neighbour);
                }
            }

            if(processed != SIZE) {
                return false;
            }
            return true;
        }
    }
}
