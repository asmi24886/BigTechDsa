package com.solutions.neetcode.twopointers.LC680;

public class ValidPalindromeII {

    class Solution {
        public boolean validPalindrome(String s) {

            int i = 0; int j = s.length() - 1;

            while (i < j) {
                if(s.charAt(i) != s.charAt(j)) {
                    if (isPalindrome(s, i+1, j) || isPalindrome(s,i,j-1)) {
                        return true;
                    }
                    else return false;
                }

                i++;j--;
            }

            return true;
        }

        private boolean isPalindrome(String s, int l, int r) {

            while (l < r) {
                if(s.charAt(l) != s.charAt(r)) {
                    return false;
                }
                l++;r--;
            }

            return true;
        }
    }
}
