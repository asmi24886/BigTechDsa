package com.solutions.neetcode.backtracking.LC131;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    class Solutio2 {
        boolean [][] dp;
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();

        public List<List<String>> partition(String s) {
            //"abacab"

            dp = new boolean [s.length()][s.length()];

            for(int i = 0; i < s.length(); i++) {
                for(int j = 0; j < s.length(); j++) {
                    if(dp[i] == dp[j]) dp[i][j] = true;
                }
            }

            helper(0, s);
            return res;
        }

        void helper(int start, String s) {

            if(start == s.length()) {
                res.add(new ArrayList<>(list));
                return;
            }

            for(int p = start; p < s.length(); p++) {

                if(isPalindrome(s, start, p)) {
                    list.add(s.substring(start, p+1));
                    helper(p+1, s);
                    list.remove(list.size() - 1);
                }
            }
        }

        boolean isPalindrome(String s, int start, int end) {
//            String sub = s.substring(start, end + 1);
//            String rev = new StringBuilder(sub).reverse().toString();
//            return sub.equals(rev);

            if(s.charAt(start) == s.charAt(end)) {
                int nextStart = start+1;
                int nextEnd = end-1;

                if(nextStart >= nextEnd) {
                    dp[start][end] = true;
                }
                else {
                    dp[start][end] = dp[nextStart][nextEnd];
                }
            }
            else dp[start][end] = false;

            return dp[start][end];
        }
    }


    class Solution {
        boolean [][] dp;
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();

        public List<List<String>> partition(String s) {
            //"abacab"

            dp = new boolean [s.length()][s.length()];
            int n = s.length();

            for(int l = 0; l < n; l++) {
                for(int i = 0; i < n - l ; i++) {
                    int j = i+l;
                    if(i == j) {
                        dp[i][j] = true;
                        continue;
                    }

                    if(s.charAt(i) != s.charAt(j)) {
                        dp[i][j] = false;
                        continue;
                    }

                    if(i + 1 > j - 1) {
                        dp[i][j] = true;
                    }
                    else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
            }

            helper(0, s);
            return res;
        }

        void helper(int start, String s) {

            if(start == s.length()) {
                res.add(new ArrayList<>(list));
                return;
            }

            for(int p = start; p < s.length(); p++) {

                if(dp[start][p]) {
                    list.add(s.substring(start, p+1));
                    helper(p+1, s);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
