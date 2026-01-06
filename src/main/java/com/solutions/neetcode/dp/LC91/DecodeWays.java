package com.solutions.neetcode.dp.LC91;

import java.util.Arrays;

public class DecodeWays {

    class Solution {
        int dp [][];
        int dp_[];
        public int numDecodings(String s) {
            return dp_decode(s);
        }

        int dp_decode(String s) {
            dp_ = new int [s.length()];

            for(int i = s.length() - 1; i >= 0; i--) {

                if(s.charAt(i) == '0') {
                    dp_[i] = 0;
                    continue;
                }

                if(i == s.length() - 1) {
                    dp_[i] = 1;
                    continue;
                }

                if(i == s.length() - 2) {
                    if(Integer.parseInt( s.substring(i, s.length()) ) > 26)
                        dp_[i] = 0;
                    else
                        dp_[i] = 1+ dp_[i+1];

                    continue;
                }

                dp_[i] = dp_[i+1];

                if(Integer.parseInt( s.substring(i, i+2) ) > 26)
                    continue;

                dp_[i] += dp_[i+2];
            }
            return dp_[0];
        }

        int recursive_decode(String s) {
            dp = new int[s.length()][s.length()];
            Arrays.stream(dp).forEach(it -> Arrays.fill(it, -1));
            return decode(0, 0, s) + decode(0, 1, s);
        }

        int decode(int l, int r, String s) {
            System.out.println(l + " --- " + r);
            if(l == s.length() || r == s.length()) return 0;

            if(dp[l][r] != -1) return dp[l][r];

            if( s.charAt(l) == '0' ) {
                return 0;
            }
            if(l+1 == r && Integer.parseInt(s.substring(l, r+1)) > 26) {
                return 0;
            }
            if(l == s.length() - 1 || r == s.length() - 1) {
                return 1;
            }

            if(l == r) return decode(l+1, l+1, s) + decode(l+1, l+2, s);

            dp[l][r] = decode(r+1, r+1, s) + decode(r+1, r+2, s);
            return dp[l][r];
        }
    }
}
