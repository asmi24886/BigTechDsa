package com.solutions.neetcode.stack.LC232;

import java.util.Stack;

public class ImplementQueueUsingStack {

    class MyQueue {
        private Stack<Integer> stack;
        private Stack<Integer> temp;

        public MyQueue() {
            stack = new Stack<>();
            temp = new Stack<>();
        }

        public void push(int x) {
            while (!stack.isEmpty()) {
                temp.push(stack.pop());
            }
            stack.push(x);
            while(!temp.isEmpty()) {
                stack.push(temp.pop());
            }
        }

        public int pop() {
            return stack.pop();
        }

        public int peek() {
            return stack.peek();
        }

        public boolean empty() {
            return stack.isEmpty();
        }
    }

}
