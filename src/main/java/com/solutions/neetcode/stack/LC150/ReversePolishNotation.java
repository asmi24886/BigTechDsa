package com.solutions.neetcode.stack.LC150;

import java.util.Stack;

public class ReversePolishNotation {

    class Solution {
        public int evalRPN(String[] tokens) {

            Stack<String> stack = new Stack<>();

            for(String token : tokens) {

                if(isOperator(token)) {
                    stack.push(
                            doOperation(
                                    Integer.parseInt(stack.pop()),
                                    Integer.parseInt(stack.pop()),
                                    token
                            )+""
                    );
                }
                else {
                    stack.push(token);
                }
            }



            return Integer.parseInt(stack.pop());

        }

        public boolean isOperator(String s) {
            if(s.equals("+") || s.equals("-") || s.equals("") || s.equals("/"))
                return true;

            return false;
        }

        public int doOperation(int op1, int op2, String operator) {
            if(operator.equals("+")) {
                return op1 +  op2;
            }
            else if(operator.equals("-")) {
                return op2 - op1;
            }
            else if(operator.equals("")) {
                return op1   op2;
            }
            else if(operator.equals("/")) {
                return op2 /  op1;
            }
            else return op1;
        }
    }
}
