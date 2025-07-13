package com.solutions.neetcode.greedy.LC134;

public class GasStation {

    public static void main(String [] args) {
        Solution sol = new Solution();
        int [] gas = {6,1,4,3,5};
        int [] cost = {3,8,2,4,2};

        //[3, -7, 2, -1, 3]
        System.out.println(sol.canCompleteCircuit(gas, cost));
    }

    static class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int sum = 0;
            int total = 0;
            int startIndex = -1;

            for(int i=0; i < gas.length; i++) {
                int residual = gas[i] - cost[i];
                sum+=residual;

                if(residual >= 0 && startIndex == -1) {
                    startIndex = i;
                }

                if(startIndex > -1) {
                    total+=residual;
                }

                if(total < 0) {
                    startIndex = -1;
                    total = 0;
                }
            }

            return sum < 0 ? -1 : startIndex;
        }
    }
}
