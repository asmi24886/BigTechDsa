package com.solutions.neetcode.math.LC43;

public class MultiplyStrings {

    class Solution {
        public String multiply(String num1, String num2) {

            if(num1.equals("0") || num2.equals("0"))
                return "0";

            int [] res = new int [num1.length() + num2.length()];
            char [] chars1 = new StringBuilder(num1).reverse().toString().toCharArray();
            char [] chars2 = new StringBuilder(num2).reverse().toString().toCharArray();

            for(int i = 0; i < chars1.length; i++) {
                int n1 = chars1[i] - '0';
                int start = i;
                int carry = 0;

                for(int j = 0; j < chars2.length; j++) {

                    int n2 = chars2[j] - '0';

                    int multi = (n1*n2) + carry + res[start]; // carry from previous
                    int curr = multi%10;

                    res[start] = curr;
                    start++;
                    carry = multi/10;
                }

                res[start]+=carry;
            }

            StringBuilder builder = new StringBuilder();
            //System.out.println(Arrays.stream(res).boxed().toList());
            int i = res[res.length-1] == 0? res.length-2 : res.length-1;
            while(i >= 0) {
                builder.append((char) ('0' + res[i]));
                i--;
            }
            return builder.toString();
        }
    }

}
