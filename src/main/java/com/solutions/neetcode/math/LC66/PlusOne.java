package com.solutions.neetcode.math.LC66;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlusOne {

    class Solution {
        public int[] plusOne(int[] digits) {
            List<Integer> list = new ArrayList<>();
            boolean carry = true;
            for(int i = digits.length - 1; i >= 0; i--) {
                int digit = digits[i];
                if(carry)
                    digit+=1;
                if(digit > 9) carry = true;
                else carry = false;

                list.add(digit%10);
            }

            if(carry) list.add(1);
            Collections.reverse(list);
            return list.stream().mapToInt(i -> i).toArray();
        }
    }
}
