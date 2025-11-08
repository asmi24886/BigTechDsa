package com.solutions.neetcode.graph.LC210;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CourseSchedule2 {
    class Solution {
        List<List<Integer>> adj =  new ArrayList<>();
        Stack<Integer> stack =  new Stack<>();

        int SIZE;
        int [] state;

        int VISITING = 1;
        int VISITED = 2;

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            SIZE = numCourses;
            state = new int[SIZE];

            for(int i = 0; i < SIZE; i++) {
                adj.add(new ArrayList<>());
            }

            for(int [] pre : prerequisites) {
                adj.get(pre[1]).add(pre[0]);
            }

            for(int i = 0; i < SIZE; i++) {
                if(state[i] == VISITED) continue;;
                if(!dfs(i)) return new int []{};
            }

            //System.out.println(stack);
            int [] result = new int[SIZE];
            for(int i = 0; i < SIZE; i++) {
                result[i] = stack.pop();
            }

            return result;
        }

        boolean dfs(int course) {
            if(state[course] == VISITED) return true;
            if(state[course] == VISITING) return false;
            state[course] = VISITING;

            List<Integer> neighbours = adj.get(course);
            for(int n : neighbours) {
                if(!dfs(n)) return false;
            }

            state[course] = VISITED;
            stack.push(course);
            return true;
        }
    }
}
