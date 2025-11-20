package com.solutions.neetcode.stack.LC853;

import java.util.;

public class CarFleet {

    class Solution {
        // Remember it is a SINGLE LANE, so no car can by pass the other; thats the important hint here
        public int carFleet(int target, int[] position, int[] speed) {

            int [][] sortedCars = new int[position.length][2];

            for(int i = 0; i < position.length; i++) {
                sortedCars[i] = new int [] {position[i], speed[i]};
            }

            Arrays.sort(sortedCars, Comparator.comparingInt( (int [] arr) -> arr[0]).thenComparingInt(arr -> arr[1]));

            Stack<int []> stack = new Stack<>();
            for(int i = position.length - 1; i >= 0; i--) {
                if(stack.isEmpty()) {
                    stack.push(sortedCars[i]);
                    continue;
                }

                int [] carMetric = stack.peek();
                double timeOfLastFleet = (target  1.0 - carMetric[0]  1.0) / carMetric[1]; // distance / speed

                double timeOfCurrent = (target  1.0 - sortedCars[i][0]  1.0) / sortedCars[i][1];

                //this car can catch up
                if(timeOfCurrent > timeOfLastFleet) {
                    stack.push(sortedCars[i]);
                }
            }
            return stack.size();

        }
    }
}