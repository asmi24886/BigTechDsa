package com.solutions.neetcode.backtracking.LC17;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfAPhoneNumber {

    class Solution {

        List<String> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        Map<Character, List<Character>> charMap = Map.of(
                '2', List.of('a', 'b', 'c'),
                '3', List.of('d', 'e', 'f'),
                '4', List.of('g', 'h', 'i'),
                '5', List.of('j', 'k', 'l'),
                '6', List.of('m', 'n', 'o'),
                '7', List.of('p', 'q', 'r', 's'),
                '8', List.of('t', 'u', 'v'),
                '9', List.of('w', 'x', 'y', 'z')
        );


        public List<String> letterCombinations(String digits) {

            helper(digits, 0);
            return result;
        }

        void helper(String digits, int digit_i) {
            if(digits.length() == digit_i) {
                result.add(builder.toString());
                return;
            }

            List<Character> chars = charMap.get(digits.charAt(digit_i));

            for(char c : chars) {
                builder.append(c);
                helper(digits, digit_i+1);
                builder.deleteCharAt(builder.length() - 1);
            }
        }
    }
}
