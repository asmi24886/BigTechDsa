package com.solutions.neetcode.greedy.LC678;

import java.util.Stack;

public class ValidParenthesisString {

    public static void main(String[] args) {
        System.out.println(new Solution().checkValidString("(*))"));
    }

    static class Solution {


        /*
            The idea:
            if we encounter a ( then leftBrace = existing count of leftBrace + 1
            if we encounter a ) then leftBrace = existing count of leftBrace - 1
            so if count of lwft brace is ever < 0 this means we already have a lot of right braces from which we can never recover

            BUT
            if we encounter * then we have three options.
            1. consider we took a ) and leftmin was decreased
            2. consider we took a ( and leftMax was increased
            3. if leftmin is -1, this means we can prevent this by considering wildcard as *


            This solution is very non intuitive. Maybe memorize and implement whereever possible

         */
        public boolean checkValidString(String s) {

            char [] chars = s.toCharArray();

            int openMin = 0;
            int openMax = 0;
            for(char c: chars) {

                if(c == '(') {
                    openMin++;
                    openMax++;
                }
                else if(c == ')') {
                   openMin--;
                   openMax--;
                }
                else {
                    openMin--;
                    openMax++;
                }

                openMin = Math.max(0,openMin);
                if(openMax < 0) return false;
            }

            return openMin == 0;
        }

    }
}
