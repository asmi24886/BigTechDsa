package com.solutions.neetcode.linkedlist.LC287;

// Check the BIT COUNTING pattern for this problem
public class FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        return findDuplicate_negation(nums);
    }

    public int findDuplicate_negation(int [] nums) {

        for(int i = 0; i < nums.length; i++) {

            int idx = nums[i];
            if(nums[Math.abs(idx)] - 1 < 0)
                return Math.abs(idx);

            nums[Math.abs(idx)] = nums[Math.abs(idx)]  -1;
        }
        return 0;
    }

    public int floydCycleDetection(int [] nums) {
        int sp = 0;
        int fp = 0;

        while(true) {
            fp = nums[nums[fp]];
            sp = nums[sp];

            if(sp == fp) break;
        }

        int sp2 = 0;

        while(true) {
            sp = nums[sp];
            sp2 = nums[sp2];

            if(sp == sp2) break;
        }

        return sp2;
    }
}
