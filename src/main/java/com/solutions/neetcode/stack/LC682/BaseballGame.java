package com.solutions.neetcode.stack.LC682;

import java.util.Stack;

public class BaseballGame {

    class Solution {
        public int calPoints(String[] operations) {

            Stack<Integer> stack = new Stack<>();

            for (String op : operations) {
                try {
                    stack.push(Integer.parseInt(op));
                }
                catch (Exception e) {
                    if(stack.isEmpty()) {
                        continue;
                    }

                    if(op.equals("C")) {
                        stack.pop();
                        continue;
                    }

                    if(op.equals("D")) {
                        stack.push(stack.peek() * 2);
                        continue;
                    }

                    int second = stack.pop();
                    int first = stack.isEmpty() ? 0 : stack.peek();
                    int sum = second+first;

                    stack.push(second);
                    stack.push(sum);

                }
            }

            return stack.stream().mapToInt(it -> it).sum();
        }
    }
}
