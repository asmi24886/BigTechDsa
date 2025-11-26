package com.solutions.neetcode.math.LC202;

import java.util.HashSet;

public class HappyNumber {
    class Solution {

        public boolean isHappy(int n) {

            int slow = n; int fast = getSumOfNumberSquared(n);

            while(slow != fast) {
                fast = getSumOfNumberSquared(fast);
                fast = getSumOfNumberSquared(fast);
                slow = getSumOfNumberSquared(slow);
            }

            return slow == 1;

        }

        public boolean isHappy2(int n) {

            HashSet<Integer> set = new HashSet<>();

            while(set.add(n)) {
                n = getSumOfNumberSquared(n);
                if(n == 1) return true;
            }

            return false;

        }

        int getSumOfNumberSquared(int n) {
            int sum = 0;

            while(n != 0) {
                sum += Math.pow(n%10, 2);
                n/=10;
            }

            return sum;
        }
    }
}
