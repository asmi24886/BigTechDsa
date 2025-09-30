package com.solutions.neetcode.stack.LC22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class GenerateParentheses {

    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(1));
    }
    static class Solution {
        Stack<String> stack = new Stack<>();
        List<String> result = new ArrayList<>();
        public List<String> generateParenthesis(int n) {

            generate(n, n);
            return result;
        }

        public void generate(int openNumber, int closeNumber) {
            if(openNumber == 0 && closeNumber == 0) {
                result.add(String.join("", stack));
                return;
            }

            // we can still add an open parentheses
            if(openNumber > 0) {
                stack.push("(");
                generate(openNumber-1, closeNumber);
                stack.pop();
            }

            if(closeNumber > openNumber) {
                stack.push(")");
                generate(openNumber, closeNumber-1);
                stack.pop();
            }
        }
    }

}
